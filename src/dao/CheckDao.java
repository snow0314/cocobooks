package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Member;
import common.JdbcUtill;

public class CheckDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public CheckDao() {
		con=JdbcUtill.getConnection();
	}
	public void close() {
		JdbcUtill.close(rs, pstmt, con);
	}
	public Member check(String id) {
		Member mb=null;
		String sql="SELECT MB_KIND_NUM\r\n" + 
				"FROM MEMBER\r\n" + 
				"WHERE MB_ID=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				mb=new Member();
				mb.setKind(rs.getNString("MB_KIND_NUM"));
			}
			return mb;
		} catch (SQLException e) {
			System.out.println("등급 조회 예외");
			e.printStackTrace();
		}
		
		return mb;
	}
	public List<String> categoryCheck() {
		List<String> list=null; 
		String sql="SELECT GE_NAME FROM GENRE";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			list=new ArrayList<String>();
			while (rs.next()) {
				list.add(rs.getNString("GE_NAME"));
			}
			System.out.println("장르이름"+list);
			return list;
		} catch (SQLException e) {
			System.out.println("장르 긁어오기 예외 ");
			e.printStackTrace();
		}
		return list;
	}
	
}
