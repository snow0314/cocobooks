package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Member;
import common.JdbcUtill;

public class ShowMyInfoDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ShowMyInfoDao() {
		con=JdbcUtill.getConnection();
	}
	public void close() {
		JdbcUtill.close(rs, pstmt, con);
	}
	public Member showMyInfo(String id) {
		Member mb=null;
		String sql="SELECT * FROM MEMBER WHERE MB_ID=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				mb=new Member();
				mb.setId(rs.getNString("MB_ID"));
				mb.setName(rs.getNString("MB_NAME"));
				mb.setAge(rs.getInt("MB_AGE"));
				mb.setEmail(rs.getNString("MB_EMAIL"));
				mb.setKind(rs.getNString("MB_KIND_NUM"));
				mb.setCoin(rs.getInt("MB_COIN"));
				mb.setApply(rs.getNString("MB_APPLY"));
			}
			return mb;
		} catch (SQLException e) {
			System.out.println("프로필 예외");
			e.printStackTrace();
		}
		
		return mb;
	}
}
