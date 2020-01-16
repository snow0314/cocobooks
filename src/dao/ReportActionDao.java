package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Report;
import common.JdbcUtill;

public class ReportActionDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public boolean reportCheck(Report rt) {
		String sql="SELECT * FROM DT WHERE DT_STORY_NUM=? AND DT_NAME=? AND DT_ID=?";
		con=JdbcUtill.getConnection();
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, rt.getStory_num());
			pstmt.setNString(2, rt.getName());
			pstmt.setNString(3, rt.getId());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("이미 신고함");
				return true;
			}else {
				System.out.println("신고 안했음");
				return false;
			}
			
		} catch (SQLException e) {
			System.out.println("신고 체크 오류");
			e.printStackTrace();
		}
		
		return true;
	}

	public boolean reportAdd(Report rt) {
		String sql="INSERT INTO DT VALUES(?,?,?,?,?)";
		con=JdbcUtill.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, rt.getStory_num());
			pstmt.setNString(2, rt.getName());
			pstmt.setNString(3, rt.getId());
			pstmt.setNString(4, rt.getCategory());
			pstmt.setNString(5,rt.getDetail());
			int result=pstmt.executeUpdate();
			
			if(result!=0) {
				System.out.println("신고 성공");
				return true;
			}else {
				System.out.println("신고 실패");
				return false;
			}
			
		} catch (SQLException e) {
			System.out.println("신고 등록 오류");
			e.printStackTrace();
		}
		
		return false;
	}

}
