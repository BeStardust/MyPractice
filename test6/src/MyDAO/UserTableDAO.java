package MyDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import enity.User;

public class UserTableDAO {
	private Connection conn=null;
	private PreparedStatement pst=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public UserTableDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean AddUser(User user){
		
		String sql="insert into usertable values(DEFAULT,?,?)";
		try{
			pst=conn.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
		
	}
	public void close(){
		try{
			pst.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
