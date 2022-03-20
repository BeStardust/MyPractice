package wztDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class WztDBcon {
	
	Connection conn=null;
	public Connection connection(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			              
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspexe", "root", "wuzhuanti");
		                                    
			System.out.println("linked");
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("not linked");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	public void close(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
