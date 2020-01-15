package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JdbcUtill;

public class RecommendationDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public boolean recAdd(String id, int sNum) {
		String sql="INSERT INTO RT VALUES(?,?)";
		con=JdbcUtill.getConnection();
		int result=0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, sNum);
			pstmt.setNString(2, id);
			result=pstmt.executeUpdate();
			
			if(result!=0) {
				System.out.println("추천성공");
				return true;
			}else {
				System.out.println("추천 실패");
				return false;
			}
			
		} catch (SQLException e) {
			System.out.println("추천 오류");
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean recCheck(String id, int sNum) {
		String sql="SELECT * FROM RT WHERE RT_STORY_NUM=? AND RT_ID=?";
		con=JdbcUtill.getConnection();
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, sNum);
			pstmt.setNString(2, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				//추천을 이미 했으면 true
				return true;
			}else {
				//추천을 안했으면 false 반환
				return false;
			}
			
		} catch (SQLException e) {
			System.out.println("recCheck 오류");
			e.printStackTrace();
		}
		
		return true;
	}

}
