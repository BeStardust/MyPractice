package DAO;

import java.sql.*;

import DB.*;
import User.*;

public class DoUser {

	public boolean searchUser(User user) {
		DBconn dbconn = new DBconn();
		Connection conn = dbconn.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement("select * from User");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				if (rs.getString(1).equals(user.getName())) {
					return true;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbconn.close();

		return false;

	}

	public boolean addUser(User user) {
		DBconn dBconn = new DBconn();
		Connection conn = dBconn.getConnection();

		try {
			PreparedStatement pst = conn
					.prepareStatement("insert into User values(?)");
			pst.setString(1, user.getName());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

}