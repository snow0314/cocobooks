package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Member;

public class SignupDao {
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
	
	
	public boolean signup(Member mb) {
		String sql="INSERT INTO MEMBER(MB_ID,MB_PW,MB_NAME,MB_AGE,MB_EMAIL,MB_GENDER) VALUES(?,?,?,?,?,?)";
		
		try {
			
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, mb.getId());
			pstmt.setNString(2, mb.getPw());
			pstmt.setNString(3, mb.getName());
			pstmt.setInt(4, mb.getAge());
			pstmt.setNString(5, mb.getEmail());
			pstmt.setNString(6, mb.getGender());
			int result=pstmt.executeUpdate();
			
			if(result !=0) {
				System.out.println("회원가입 성공");
				return true;
			}
			
			
		} catch (SQLException e) {
			System.out.println("회원가입 오류 발생");
			e.printStackTrace();
		}
		
		return false;
	}

}
