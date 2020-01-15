package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Novel;
import common.JdbcUtill;

public class NovelInsertDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public NovelInsertDao() {
		con=JdbcUtill.getConnection();
	}
	public void close() {
		JdbcUtill.close(rs, pstmt, con);
	}
	public int genreCheck(String genre) {
		int genreNum=0;
		String sql="SELECT GE_NUM FROM GENRE WHERE GE_NAME=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, genre);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				genreNum=(rs.getInt("GE_NUM"));
				System.out.println("장르번호"+genreNum);
			}
			return genreNum;
		} catch (SQLException e) {
			System.out.println("장르 번호 가져오기 예외");
			e.printStackTrace();
		}
		return genreNum;
	}
	public boolean insert(String id, String title, String contents, String grade, int genreNum, String kind) {
		boolean result=false;
		String sql="INSERT INTO NOBEL \r\n" + 
				"VALUES(NO_NUM_SEQ.NEXTVAL,?\r\n" + 
				",?,\r\n" + 
				"?\r\n" + 
				",?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, id);
			pstmt.setNString(2,	title);
			pstmt.setNString(3, contents);
			pstmt.setNString(4, grade);
			pstmt.setInt(5, genreNum);
			pstmt.setNString(6, kind);
			int number=pstmt.executeUpdate();
			if(number!=0) {
				result=true;
				return result;
			}
		} catch (SQLException e) {
			System.out.println("작품 등록 예외");
			e.printStackTrace();
		}
		
		return result;
	}
	
}
