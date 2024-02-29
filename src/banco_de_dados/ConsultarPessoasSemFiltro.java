package banco_de_dados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultarPessoasSemFiltro {

	public static void main(String[] args) throws SQLException {
		
		Connection conexao = FabricaConexao.getConexao();
		String sql = "SELECT * FROM pessoas";
		Statement statement = conexao.createStatement();
		
		ResultSet resultado = statement.executeQuery(sql);
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while(resultado.next()) {
			int codigo = resultado.getInt("codigo");
			String nome = resultado.getString("nome");
			pessoas.add(new Pessoa(codigo, nome));
		}
		
		for(Pessoa p: pessoas) {
			System.out.println(p.getCodigo() + " ====> " + p.getNome());
		}
		
		conexao.close();
	}
	
}
