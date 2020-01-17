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

	public int coinCheck(String id) {
		String sql="SELECT * FROM MB WHERE MB_ID=?";
		con=JdbcUtill.getConnection();
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				int coin=rs.getInt("MB_COIN");
				return coin;
			}
			
		} catch (SQLException e) {
			System.out.println("코인체크 오류");
			e.printStackTrace();
		}
		
		return 0;
	}

	public void coinDown(String id,int coin) {
		String sql="update mb set MB_COIN=? where mb_id=?";
		con=JdbcUtill.getConnection();
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, coin);
			pstmt.setNString(2, id);
			int result=pstmt.executeUpdate();
			
			if(result!=0) {
				System.out.println("코인 소비 성공");
			}else {
				System.out.println("코인 소비 실패");
			}
			
		} catch (SQLException e) {
			System.out.println("코인 소비 오류");
			e.printStackTrace();
		}
		
	}

}
