package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException, IOException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "trmsAdmin";
		String password = "trmspass";

		return DriverManager.getConnection(url, user, password);
	}
}