package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JdbcUtill;

public class IdSearchDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public String idsearch(String name,String email) {
		String id=null;
		con = JdbcUtill.getConnection();
		try {
			String sql = "SELECT * FROM MEMBER WHERE MB_NAME=? AND MB_EMAIL=?";
			PreparedStatement pstmt =con.prepareStatement(sql);
			pstmt.setNString(1, name);
			pstmt.setNString(2, email);
			
			rs=pstmt.executeQuery();
			
			if(rs.next())
				id=rs.getNString("MB_ID");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
}
