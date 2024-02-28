package banco_de_dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	public static Connection getConexao() {
		try {
			final String url = "jdbc:mysql://localhost/estudo_java?verifyServerCertificate=false&useSSL=true";
			final String usuario = "root";
			final String senha = "123456789!";
			
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
