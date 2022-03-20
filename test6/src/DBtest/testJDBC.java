package DBtest;

import enity.User;
import MyDAO.UserTableDAO;
import myDB.myDBconn;

public class testJDBC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myDBconn conn= new myDBconn();
		conn.getConnection();
		User user = new User();
		user.setUsername("ÍõÎå");
		user.setPassword("wangwu");
		UserTableDAO insertUser= new UserTableDAO(conn.getConnection());
		insertUser.AddUser(user);
		conn.close();
		insertUser.close();
		
	}

}
