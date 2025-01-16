package br.mil.eb.sgr.sgr.dto;

import br.mil.eb.sgr.sgr.entities.Usuario;

public class UsuarioRegistroDTO extends UsuarioDTO {
	private static final long serialVersionUID = 6566672022733335644L;

	private String password;
	
	public UsuarioRegistroDTO() {
	}
	
	public UsuarioRegistroDTO(Usuario usuario) {
		super(usuario);
		
		this.password = usuario.getPassword();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Essa classe não pode ser transformada em string por razões de segurança.";
	}
}
