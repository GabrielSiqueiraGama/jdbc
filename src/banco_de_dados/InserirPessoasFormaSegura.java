package banco_de_dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InserirPessoasFormaSegura {

	public static void main(String[] args) throws SQLException {
		/*Nesta classe é feita a injeção de pessoas de forma
		 *  protegida pra evitar injeções de SQL mal intencionadas*/
		Connection conexao = FabricaConexao.getConexao();
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Informe o nome: ");
		String nome = scn.nextLine();
		
		String sql = "INSERT INTO pessoas (nome) VALUES (?)";
		PreparedStatement p_statement = conexao.prepareStatement(sql);
		p_statement.setString(1, nome);
		
		p_statement.execute();
		System.out.println("Pessoa incluida com sucesso");
		scn.close();
	}
	
}
