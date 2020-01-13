package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JdbcUtill;

public class StoryDeleteDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public boolean deleteOne(int storyNum) {
		String sql="DELETE FROM DECLARATION WHERE DT_STORY_NUM=?";
		con=JdbcUtill.getConnection();
		int result;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, storyNum);
			result=pstmt.executeUpdate();
			
			if(result!=0) {
				System.out.println("삭제 성공");
				return true;
			}else {
				System.out.println("삭제 실패");
				return false;
			}
			
		} catch (SQLException e) {
			System.out.println("삭제 오류");
			e.printStackTrace();
		}
		return false;
		
	}

	public boolean deleteTwo(int storyNum) {
		String sql2="DELETE FROM STORY WHERE SR_NUM=?";
		con=JdbcUtill.getConnection();
		int result;
		
		try {
			pstmt=con.prepareStatement(sql2);
			pstmt.setInt(1, storyNum);
			result=pstmt.executeUpdate();
			if(result!=0) {
				System.out.println("삭제 성공");
				return true;
			}else {
				System.out.println("삭제 실패");
				return false;
			}
			
			
		} catch (SQLException e) {
			System.out.println("삭제 오류2");
			e.printStackTrace();
		}
		
		
		
		return false;
	}

}
