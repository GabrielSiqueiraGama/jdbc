package banco_de_dados;

public class DAOTeste {

	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		String sql = "INSERT INTO pessoas (nome) VALUES (?)";
		System.out.println(dao.incluir(sql, "FAIT"));
		System.out.println(dao.incluir(sql, "Aang"));
		System.out.println(dao.incluir(sql, "fuwu"));
		
		
		dao.close();
	}
	
}
