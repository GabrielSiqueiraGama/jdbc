package banco_de_dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizarNome {

	public static void main(String[] args) throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		String sqlSelect = "SELECT codigo, nome FROM pessoas WHERE codigo = ?";
		String sqlUpdate = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Digite o codigo do nome que deseja substituir: ");
		int codigo = scn.nextInt();

		PreparedStatement statement = conexao.prepareStatement(sqlSelect);
		statement.setInt(1, codigo);
		ResultSet resultado = statement.executeQuery();
		
		if(resultado.next()) {
			Pessoa pessoa = new Pessoa(resultado.getInt(1), resultado.getString(2));
			
			System.out.println("O nome atual é: " + pessoa.getNome());
			
			System.out.println("Digite o novo nome: ");
			scn.nextLine();
			String novoNome = scn.nextLine();
			
			statement.close();
			statement = conexao.prepareStatement(sqlUpdate);
			statement.setString(1, novoNome);
			statement.setInt(2, codigo);
			statement.execute();

			System.out.println("Alterado com sucesso");
		}
		

		scn.close();
		conexao.close();
	}
	
}
