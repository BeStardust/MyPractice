 package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import enity.User;


import DB.DBconn;

public class UserDao {
	
	DBconn dbconn=new DBconn();
	Connection conn=dbconn.connection("jdbc:mysql://localhost:3306/androidapp", "root", "wuzhuanti");
	public boolean seekUser(User user) {
		String sql="select * from User where account=?";
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, user.getAccount());
			ResultSet rs=pst.executeQuery();
			while (rs.next()) {
				if (rs.getString(1).equals(user.getAccount())&&rs.getString(2).equals(user.getPassword())) {
					conn.close();
					dbconn.close();
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
