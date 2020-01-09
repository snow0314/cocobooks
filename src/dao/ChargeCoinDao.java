package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JdbcUtill;

public class ChargeCoinDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ChargeCoinDao() {
		con=JdbcUtill.getConnection();
	}
	public void close() {
		JdbcUtill.close(rs, pstmt, con);
	}
	public boolean ChargeCoin(String id, int coin) {
		String sql="UPDATE MEMBER SET MB_COIN =MB_COIN+? WHERE MB_ID = ?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, coin);
			pstmt.setNString(2, id);
			int result=pstmt.executeUpdate();
			if(result!=0) {
				System.out.println("충전 성공");
				return true;
			}else {
				System.out.println("충전 실패");
			   return false;
			}
		} catch (SQLException e) {
			System.out.println("충전 예외");
			e.printStackTrace();
		}
		return false;
	}
	
	
	
}
