package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
	private static Connection con = null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:mariadb://192.168.2.5:3306/gdproject";
		String id = "goodee";
	   	String pwd = "1234";
	   	
	    Class.forName("org.mariadb.jdbc.Driver");
	    con = DriverManager.getConnection(url, id, pwd);
	      
		if(con == null)
			return DBCon.getConnection();
		
		return con;
	}
}
