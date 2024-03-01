package banco_de_dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoaPeloNome {

	public static void main(String[] args) throws SQLException{
		
		Connection conexao = FabricaConexao.getConexao();
		Scanner scn = new Scanner(System.in);
		String sqlDelete = "DELETE FROM pessoas WHERE nome = ?";
		
		
		System.out.println("Digite o nome da pessoa que deseja excluir");
		String nome = scn.nextLine();
		
		PreparedStatement statement = conexao.prepareStatement(sqlDelete);
		statement.setString(1, nome);
		
		if(statement.executeUpdate() > 0 ) {
			System.out.println("Pessoa excluida com sucesso");
		}else {
			System.out.println("Pessoa não encontrada.");
		}
		
		scn.close();
		conexao.close();
	}
	
}
