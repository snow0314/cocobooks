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
		String sql="UPDATE WHERE MB_ID=?"; //
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, "");
			pstmt.setInt(2, coin);
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
