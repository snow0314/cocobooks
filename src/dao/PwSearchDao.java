package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JdbcUtill;

public class PwSearchDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public String pwsearch(String id,String email) {
		String pw=null;
		con = JdbcUtill.getConnection();
		try {
			String sql = "SELECT * FROM MEMBER WHERE MB_ID=? AND MB_EMAIL=?";
			PreparedStatement pstmt =con.prepareStatement(sql);
			pstmt.setNString(1, id);
			pstmt.setNString(2, email);
			
			rs=pstmt.executeQuery();
			
			if(rs.next())
				pw=rs.getNString("MB_PW");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return pw;
	}
}
