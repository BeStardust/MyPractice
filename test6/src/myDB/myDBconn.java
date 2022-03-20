package myDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class myDBconn {
	private static String DriverClass="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/jspexe";
	private static String user="root";
	private static String password="wuzhuanti";
	Connection conn=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Connection getConnection(){
		try {
			
			Class.forName(DriverClass);
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("数据库连接成功！");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return this.conn;
	}
	public void close(){
		try{
			this.conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
