package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;

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
	public boolean loginCheck(String id, String pw) {
		String sql = "SELECT * FROM MEMBER WHERE MB_ID=?";
		boolean result=false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getNString("MB_PW").equals(pw)) {
					result = true;// 모두 일치
				} else {
					result = false; // 비번불일치
				}
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	
	
}//class end
