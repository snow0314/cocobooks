package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Member;
import common.JdbcUtill;

public class CoinCheckDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public CoinCheckDao() {
		con=JdbcUtill.getConnection();
	}
	public void close() {
		JdbcUtill.close(rs, pstmt, con);
	}
	public Member coinCheck(String id) {
		Member mb = null;
		String sql="SELECT MB_COIN FROM MEMBER WHERE MB_ID=?";
		try {
			pstmt= con.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("실시간 coin 확인");
				mb= new Member();
				mb.setCoin(rs.getInt("MB_COIN"));
				return mb;
			}else {
				System.out.println("실시간 coin 확인 실패");
			}
		} catch (SQLException e) {
			System.out.println("메인 예외");
			e.printStackTrace();
		}
	
		return mb;
	}

}
