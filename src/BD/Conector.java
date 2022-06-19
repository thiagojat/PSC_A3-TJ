package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/educacao", "root", "");
			System.out.println("Conexão bem sucedida");
		} catch (Exception e) {
			System.out.println(e);
			conn = null;
		}
		return conn;
	}

	public static void CloseConnection(Connection conn) {

        try {
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void CloseConnection(Connection conn, PreparedStatement stmt) {
        CloseConnection(conn);

        try {
            if(stmt != null){
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void CloseConnection(Connection conn, PreparedStatement stmt, ResultSet rs) {
        CloseConnection(conn, stmt);
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
