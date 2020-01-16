package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Story;
import common.JdbcUtill;

public class WriteDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public boolean add(Story story) {
		String sql="INSERT INTO STORY VALUES(SR_NUM_SEQ.NEXTVAL,?,?,?,?,100,SYSDATE,DEFAULT)";
		con = JdbcUtill.getConnection();
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, story.getSR_NOBLE_NUM());
			pstmt.setNString(2, story.getSR_ID());
			pstmt.setNString(3, story.getSR_TITLE());
			pstmt.setNString(4, story.getSR_CONTENTS());
			
			int result=pstmt.executeUpdate();
			
			if(result!=0){
				System.out.println("글 등록 성공");
				return true;
			}else {
				System.out.println("글 등록 실패");
				return false;
			}
			
		} catch (SQLException e) {
			System.out.println("글 등록 오류");
			e.printStackTrace();
		}
		
		return false;
	}

}
