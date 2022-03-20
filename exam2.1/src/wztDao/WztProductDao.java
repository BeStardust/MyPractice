package wztDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import wztDB.WztDBcon;

public class WztProductDao {
	WztDBcon wztDBconn = new WztDBcon();
	Connection wztConn=wztDBconn.connection();
	public void wztAddProduct(String WZTname,String WZTxh,String WZTcs){
		String sql="insert into wztProduct values(?,?,?)";
		try {
			PreparedStatement pst=wztConn.prepareStatement(sql);
			pst.setString(1, WZTname);
			pst.setString(2,WZTxh);
			pst.setString(3, WZTcs);
			pst.executeUpdate();
			wztConn.close();
			wztDBconn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet wztFindAllProduct(){
		PreparedStatement pst;
		ResultSet rs = null;
		try {
			pst = wztConn.prepareStatement("select * from wztProduct");
			rs = pst.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		
		return rs;
		
	}
}
