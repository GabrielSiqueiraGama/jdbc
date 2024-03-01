package banco_de_dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

	private Connection conexao;
	
	public int incluir(String sql, Object... atributos) {
		try {
			PreparedStatement statement = getConexao().prepareStatement(
					sql, PreparedStatement.RETURN_GENERATED_KEYS);
			adicionarAtributos(statement, atributos);
			if(statement.executeUpdate() > 0) {
				ResultSet resultado = statement.getGeneratedKeys();
					if(resultado.next()) {
						return resultado.getInt(1);
					}
			}
			return -1;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void close() {
		try {
			getConexao().close();
		} catch (SQLException e) {
		}finally {
			conexao = null;
		}
	}
	
	private void adicionarAtributos(PreparedStatement statement,
			Object[] atributos) throws SQLException{
		
		int indice = 1;
		for(Object atributo: atributos) {
			if(atributo instanceof String) {
				statement.setString(indice, (String) atributo);
			}else if(atributo instanceof Integer) {
				statement.setInt(indice, (Integer) atributo);
			}
			indice++;
		}
	}
	
	private Connection getConexao() {
		
		try {
			if(conexao != null && conexao.isClosed()) {
				return conexao;
			}
		} catch (SQLException e) {
			
		}
		conexao = FabricaConexao.getConexao();
		return conexao;
	}
	
}
