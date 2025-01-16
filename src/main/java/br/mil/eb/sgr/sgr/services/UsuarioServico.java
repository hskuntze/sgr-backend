package br.mil.eb.sgr.sgr.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mil.eb.sgr.sgr.dto.UsuarioDTO;
import br.mil.eb.sgr.sgr.dto.UsuarioRegistroDTO;
import br.mil.eb.sgr.sgr.entities.OM;
import br.mil.eb.sgr.sgr.entities.Perfil;
import br.mil.eb.sgr.sgr.entities.Posto;
import br.mil.eb.sgr.sgr.entities.Usuario;
import br.mil.eb.sgr.sgr.repositories.OMRepositorio;
import br.mil.eb.sgr.sgr.repositories.PerfilRepositorio;
import br.mil.eb.sgr.sgr.repositories.PostoRepositorio;
import br.mil.eb.sgr.sgr.repositories.UsuarioRepositorio;
import br.mil.eb.sgr.sgr.services.exceptions.ErroProcessoException;
import br.mil.eb.sgr.sgr.services.exceptions.RecursoExistenteException;
import br.mil.eb.sgr.sgr.services.exceptions.RecursoNaoEncontradoException;
import br.mil.eb.sgr.sgr.services.exceptions.RequisicaoNaoProcessavelException;

@Service
public class UsuarioServico implements UserDetailsService {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private PerfilRepositorio perfilRepositorio;
	
	@Autowired
	private PostoRepositorio postoRepositorio;
	
	@Autowired
	private OMRepositorio omRepositorio;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	/**
	 * Busca todos os usuários cadastrados no sistema
	 * @return List<UsuarioDTO>
	 */
	@Transactional(readOnly = true)
	public List<UsuarioDTO> buscarTodos() {
		List<Usuario> usuarios = usuarioRepositorio.findAll();
		return usuarios.stream().map(u -> new UsuarioDTO(u)).collect(Collectors.toList());
	}
	
	/**
	 * Busca um usuário pelo ID
	 * @param id
	 * @return UsuarioDTO
	 */
	@Transactional(readOnly = true)
	public UsuarioDTO buscarPorId(Long id) {
		Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Usuário com ID " + id + " não foi encontrado"));
		return new UsuarioDTO(usuario);
	}
	
	/**
	 * Busca um usuário pelo email
	 * @param email
	 * @return UsuarioDTO
	 */
	@Transactional(readOnly = true)
	public UsuarioDTO buscarPorEmail(String email) {
		Usuario usuario = usuarioRepositorio.findByEmail(email);
		if(usuario == null) {
			throw new RecursoNaoEncontradoException("Usuário com email " + email + " não foi encontrado.");
		}
		return new UsuarioDTO(usuario);
	}
	
	/**
	 * Busca um usuário pela identidade
	 * @param email
	 * @return UsuarioDTO
	 */
	@Transactional(readOnly = true)
	public UsuarioDTO buscarPorIdentidade(String identidade) {
		Usuario usuario = usuarioRepositorio.findByIdentidade(identidade);
		if(usuario == null) {
			throw new RecursoNaoEncontradoException("Usuário com email " + identidade + " não foi encontrado.");
		}
		return new UsuarioDTO(usuario);
	}
	
	/**
	 * Registra um usuário na aplicação
	 * @param dto
	 * @return UsuarioDTO
	 */
	@Transactional
	public UsuarioDTO registrar(UsuarioRegistroDTO dto) {
		if(dto != null) {
			Usuario aux = usuarioRepositorio.findByIdentidade(dto.getIdentidade());
			
			if(aux == null) {
				Usuario usuario = new Usuario();
				
				if(dto.getTipo() == 1) {
					Posto p = postoRepositorio.getReferenceById(dto.getPosto().getId());
					usuario.setPosto(p);
					
					OM om = omRepositorio.getReferenceById(dto.getOm().getCodigo());
					usuario.setOm(om);
					
					usuario.setBrigada(dto.getBrigada());
				}
				
				dtoParaEntidade(usuario, dto);
				
				//TEMPORARIAMENTE DESABILITADO ATÉ RESOLVER A QUESTÃO DO SMTP DO GMAIL
				//usuario.setHabilitado(false);
				//usuario.setRegistroCompleto(false);
				usuario.setSenha(passwordEncoder.encode(dto.getPassword()));
				usuario = usuarioRepositorio.save(usuario);
				
				return new UsuarioDTO(usuario);
			} else {
				throw new RecursoExistenteException("Já existe um usuário com este número de identidade.");
			}
		} else {
			throw new RequisicaoNaoProcessavelException("Argumento nulo. Requisição improcessável.");
		}
	}
	
	@Transactional
	public UsuarioDTO atualizar(Long id, UsuarioDTO dto) {
		Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Usuário com ID " + id + " não foi encontrado"));
		
		if(dto.getTipo() == 1) {
			Posto p = postoRepositorio.getReferenceById(dto.getPosto().getId());
			usuario.setPosto(p);
			
			OM om = omRepositorio.getReferenceById(dto.getOm().getCodigo());
			usuario.setOm(om);
			
			usuario.setBrigada(dto.getBrigada());
		}
		
		dtoParaEntidade(usuario, dto);
		
		return new UsuarioDTO(usuario);
	}
	
	@Transactional
	public void trocarSenhaDoUsuario(String novaSenha, String senhaAntiga) {
		if(novaSenha != null && senhaAntiga != null) {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			Usuario usuario = usuarioRepositorio.findByIdentidade(username);
			
			if(!validarSenhaAntiga(usuario, senhaAntiga)) {
				throw new ErroProcessoException("Senha inválida.");
			}
			
			usuario.setSenha(passwordEncoder.encode(novaSenha));
			usuarioRepositorio.save(usuario);
		} else {
			throw new RequisicaoNaoProcessavelException("Requisição improcessável. Nova senha e/ou senha antiga estão vazias ou nulas.");
		}
	}
	
	public void deletar(Long id) {
		if(id == 1) {
			throw new RequisicaoNaoProcessavelException("Este usuário não pode ser excluído.");
		}
		
		usuarioRepositorio.deleteById(id);
	}

	/**
	 * Função padrão da interface "UserDetailsService" que carrega um usuário pelo 'username' dele,
	 * neste caso é o email do usuário.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByIdentidade(username);
		if(usuario == null) {
			throw new RecursoNaoEncontradoException("Usuario " + username + " não foi encontrado.");
		}
		
		return usuario;
	}

	/**
	 * Função auxiliar para passar os dados de um DTO para a entidade concreta
	 * @param usuario
	 * @param dto
	 */
	private void dtoParaEntidade(Usuario usuario, UsuarioDTO dto) {
		usuario.setNome(dto.getNome());
		usuario.setSobrenome(dto.getSobrenome());
		usuario.setEmail(dto.getEmail());
		usuario.setTelefone(dto.getTelefone());
		usuario.setIdentidade(dto.getIdentidade());
		usuario.setNomeGuerra(dto.getNomeGuerra());
		usuario.setInstituicao(dto.getInstituicao());
		usuario.setTipo(dto.getTipo());
		usuario.setFuncao(dto.getFuncao());
		
		//TEMPORÁRIO ATÉ RESOLVER A QUESTÃO DO SMTP DO GMAIL
		usuario.setHabilitado(dto.isHabilitado());
		
		usuario.getPerfis().clear();
		dto.getPerfis().forEach(perfil -> {
			Perfil p = perfilRepositorio.getReferenceById(perfil.getId());
			usuario.getPerfis().add(p);
		});
	}
	
	/**
	 * Função que valida a senha antiga do usuário para que a troca de senha seja segura
	 * @param usuario
	 * @param senhaAntiga
	 * @return boolean
	 */
	private boolean validarSenhaAntiga(Usuario usuario, String senhaAntiga) {
		return passwordEncoder.matches(senhaAntiga, usuario.getSenha());
	}
}
