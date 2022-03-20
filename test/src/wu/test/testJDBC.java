package wu.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;

public class testJDBC {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jspexe";
		String user = "root";
		String password = "wuzhuanti";
		Connection conn = null;
//		Statement stmt ;
//		ResultSet rest ;
		PreparedStatement pst = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("成功连接上数据库! ");
			String sql = "insert into usertable values(DEFAULT,?,?)";

			pst = conn.prepareStatement(sql);

			pst.setString(1,"翠花");

			pst.setString(2,"cuihua");
			int i = pst.executeUpdate();
			System.out.println(i);
			if (i > 0) {
				System.out.print("%%%");
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			if (pst != null) {
				try {
					pst.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (conn != null) {
					try {
						conn.close();

					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
