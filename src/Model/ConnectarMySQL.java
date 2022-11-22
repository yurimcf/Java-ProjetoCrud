package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectarMySQL {
	private final static String url = "jdbc:mysql://localhost:3306/projetopi";
	private final static String username = "root";
	private final static String password = "@yuri5140";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;


	public void openDB() {
		try {
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			System.out.println("\nConexÃ£o estabelecida com sucesso!\n");
		} catch (SQLException e) {
			System.out.println("\nNÃ£o foi possÃ­vel estabelecer conexÃ£o " + e + "\n");
			System.exit(1);
		}
	}

	public void closeDB() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("\nNÃ£o foi possÃ­vel fechar conexÃ£o " + e + "\n");
			System.exit(1);
		}
	}
	
	public static void main(String args[]) {
		ConnectarMySQL b = new ConnectarMySQL();
		b.openDB();
		
	}
}
