package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;

import bean.Member;
import common.JdbcUtill;

public class LoginDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public LoginDao() {
		con=JdbcUtill.getConnection();
	}
	public void close() {
		JdbcUtill.close(rs, pstmt, con);
	}
	public Member loginCheck(String id, String pw) {
		Member mb=null;
		String sql = "SELECT * FROM MEMBER WHERE MB_ID=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getNString("MB_PW").equals(pw)) {
					mb = new Member();
					mb.setCoin(rs.getInt("MB_COIN"));
					return mb; //모두 일치 하면 코인을 담아서 쏨
				} else {
					return mb; // 비번 or 아이디 불일치시 null을 보냄
				}
			} 
		} catch (SQLException e) {
			System.out.println("로그인 예외");
			e.printStackTrace();
		}
		return mb;
		
	}
	
	
	
	
}//class end
