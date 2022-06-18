package BD;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conector {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver carregado com sucesso");
		}catch(Exception e ){
			System.out.println("O Driver não carregou corretamente");
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/escola", "root", "");
			System.out.println("Conexão bem sucedida");
		} catch (Exception e) {
			System.out.println(e);
			conn = null;
		}
		return conn;
	}
}
