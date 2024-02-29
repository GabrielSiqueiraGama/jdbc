package banco_de_dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoasPeloId {

	public static void main(String[] args) throws SQLException{
		
		Connection conexao = FabricaConexao.getConexao();
		Scanner scn = new Scanner(System.in);
		String sqlDelete = "DELETE FROM pessoas WHERE codigo = ?";
		
		
		System.out.println("Digite o codigo da pessoa que deseja excluir");
		int codigoExclusao = scn.nextInt();
		
		PreparedStatement statement = conexao.prepareStatement(sqlDelete);
		statement.setInt(1, codigoExclusao);
		
		if(statement.executeUpdate() > 0 ) {
			System.out.println("Pessoa excluida com sucesso");
		}else {
			System.out.println("Pessoa não encontrada.");
		}
		
		scn.close();
		conexao.close();
	}
	
}
