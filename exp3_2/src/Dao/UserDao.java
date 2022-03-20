package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import enity.User;
import DB.DBconn;

public class UserDao {
	
	DBconn dbconn=new DBconn();
	Connection conn=dbconn.connection("jdbc:mysql://localhost:3306/jspexe", "root", "wuzhuanti");
	
	public int addUser(User user){
		
		UserDao search =new UserDao(); 
		int flag=search.searchUser(user);
		if (flag==1||flag==0) {
			System.out.println("用户已存在，请尝试登录或更改用户名尝试重新注册！");
			return 0;
		}
		try {
			String sql = "insert into usertable values(DEFAULT,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, user.getPassword());
			pst.executeUpdate();
			conn.close();
			dbconn.close();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dbconn.close();
			return -1;
		}
	
	}
	public int searchUser(User user) {
		
		String sql="select * from usertable where username=?";
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, user.getName());
			ResultSet rs=pst.executeQuery();
			while(rs.next()){

				if (rs.getString(2).equals(user.getName())) {
					if (rs.getString("password").equals(user.getPassword())) {
						System.out.println("用户名："+rs.getString(2));
						System.out.println("密码："+rs.getString(3));
						System.out.println("login seccess");
						conn.close();
						dbconn.close();
						return 1;
					}
					else {
						System.out.println("wrong password");
						conn.close();
						dbconn.close();
						return 0;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbconn.close();
		
		return -1;
		
	}
}
