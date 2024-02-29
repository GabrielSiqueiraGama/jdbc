package banco_de_dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoaCodigo {

	public static void main(String[] args) throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		String sqlId = "SELECT * FROM pessoas WHERE codigo like ?";
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Digite o codigo que deseja pesquisar: ");
		int idUsuario = scn.nextInt();
		
		
		PreparedStatement statement = conexao.prepareStatement(sqlId);
		statement.setInt(1,  idUsuario );
		ResultSet resultado = statement.executeQuery();
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while(resultado.next()) {
			int codigo = resultado.getInt("codigo");
			String nome = resultado.getString("nome");
			pessoas.add(new Pessoa(codigo, nome));
		}
		
		for(Pessoa p: pessoas) {
			System.out.println(p.getCodigo() + " ====> " + p.getNome());
		}
		scn.close();
		conexao.close();
	}
	
}
