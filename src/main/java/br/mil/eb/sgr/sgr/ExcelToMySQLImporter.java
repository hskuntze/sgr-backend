package br.mil.eb.sgr.sgr;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;

public class ExcelToMySQLImporter {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/sgr";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "diamante21";

	public static void main(String[] args) {
		try (InputStream is = new ClassPathResource("identificacao_risco_simplificado.xlsx").getInputStream();
				Workbook workbook = new XSSFWorkbook(is);
				Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {

			Sheet sheet = workbook.getSheetAt(0);
			if (sheet == null)
				throw new RuntimeException("Planilha não encontrada!");

			String sql = "INSERT INTO tb_identificacao_risco (id, projeto, contrato, tipo_risco, risco, conjunto, evento, descricao_risco, causa, data_risco, ano, data_limite, categoria, probabilidade, impacto, criticidade, severidade, consequencia, tratamento, impacto_financeiro, plano_contingencia, responsavel_risco, responsavel_conjunto, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);

			for (int rowIndex = 0; rowIndex < 83; rowIndex++) {
				Row row = sheet.getRow(rowIndex);
				if (row == null) {
					continue; // Ignora linhas vazias
				}

				// Preenche os parâmetros do PreparedStatement
				for (int colIndex = 0; colIndex < 24; colIndex++) {
					Cell cell = row.getCell(colIndex);
					
					if (cell != null) {
						// Definindo o valor para o PreparedStatement
						switch (cell.getCellType()) {
						case STRING:
							statement.setString(colIndex + 1, cell.getStringCellValue());
							break;
						case NUMERIC:
					        if (DateUtil.isCellDateFormatted(cell)) {
					            statement.setDate(colIndex + 1, new java.sql.Date(cell.getDateCellValue().getTime()));
					        } else {
					            statement.setDouble(colIndex + 1, cell.getNumericCellValue());
					        }
					        break;
						case BOOLEAN:
							statement.setBoolean(colIndex + 1, cell.getBooleanCellValue());
							break;
						case FORMULA:
							statement.setString(colIndex + 1, cell.getCellFormula());
							break;
						default:
							statement.setNull(colIndex + 1, java.sql.Types.NULL);
						}
					} else {
						statement.setNull(colIndex + 1, java.sql.Types.NULL);
					}
				}
				
				// Executa a inserção no banco
                statement.addBatch();
			}
            statement.executeBatch();

			System.out.println("✅ Importação concluída com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
