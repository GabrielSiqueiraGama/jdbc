package banco_de_dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteConexao {
	public static void main(String[] args) throws SQLException {
		
		final String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
		final String usuario = "root";
		final String senha = "123456789!";
		
		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		
		Statement statement = conexao.createStatement();
		statement.execute("CREATE DATABASE IF NOT EXISTS estudo_java");
		System.out.println("Banco criado com sucesso");
		conexao.close();
		
	}
}
