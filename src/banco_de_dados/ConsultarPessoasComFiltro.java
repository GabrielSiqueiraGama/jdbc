package banco_de_dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoasComFiltro {

	public static void main(String[] args) throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		String sql = "SELECT * FROM pessoas WHERE nome like ?";
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Digite o nome que deseja pesquisar: ");
		String nomePesquisa = scn.nextLine();
		
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setString(1, "%" + nomePesquisa + "%");
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
