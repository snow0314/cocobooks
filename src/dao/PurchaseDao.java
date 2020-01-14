package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JdbcUtill;

public class PurchaseDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public boolean buynovel(String id, String[] purchase) {
		String sql="INSERT INTO PAY_LIST VALUES(?,?,SYSDATE,100)";
		con=JdbcUtill.getConnection();
		int result=0;
		
		try {
			pstmt=con.prepareStatement(sql);
			for(int i=0; i<purchase.length;i++) {
				pstmt.setNString(1, id);
				pstmt.setInt(2, Integer.parseInt(purchase[i]));
				result=pstmt.executeUpdate();
			}
			JdbcUtill.close(rs, pstmt, con);
			
			if(result!=0) {
				return true;
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			System.out.println("구매 오류");
			e.printStackTrace();
		}
				
		return false;
	}

}
