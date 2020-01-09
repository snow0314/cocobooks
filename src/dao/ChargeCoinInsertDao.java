package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JdbcUtill;

public class ChargeCoinInsertDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ChargeCoinInsertDao() {
		con=JdbcUtill.getConnection();
	}
	public void close() {
		JdbcUtill.close(rs, pstmt, con);
	}
	public boolean insert(String id, int coin) {
		
		String sql="INSERT INTO CHARGE VALUES(CR_NUM_SEQ.NEXTVAL,?,?,SYSDATE)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, id);
			pstmt.setInt(2, coin);
			int result=pstmt.executeUpdate();
			if(result!=0) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("충전내역 insert 예외");
			e.printStackTrace();
		}
		return false;
	}
}
