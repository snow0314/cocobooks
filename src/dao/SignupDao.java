package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Member;
import common.JdbcUtill;

public class SignupDao {
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
	
	
	public boolean signup(Member mb) {
		String sql="INSERT INTO MEMBER(MB_ID,MB_PW,MB_NAME,MB_AGE,MB_EMAIL,MB_GENDER) VALUES(?,?,?,?,?,?)";
		con=JdbcUtill.getConnection();
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
				JdbcUtill.close(rs, pstmt, con);
				return true;
			}
			
			
		} catch (SQLException e) {
			System.out.println("회원가입 오류 발생");
			JdbcUtill.close(rs, pstmt, con);
			e.printStackTrace();
		}
		
		return false;
	}


	public boolean checkid(String id) {
		String sql="SELECT MB_ID FROM MEMBER WHERE MB_ID=?";
		con=JdbcUtill.getConnection();
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("중복된 아이디 있음");
				return true;
			}else {
				System.out.println("중복된 아이디 없음");
				return false;
			}
			
			
		} catch (SQLException e) {
			System.out.println("아이디 중복검사 오류");
			e.printStackTrace();
		}
		
		return false;
	}


	public boolean checkeamil(String email) {
		
		String sql="SELECT MB_EMAIL FROM MEMBER WHERE MB_EMAIL=?";
		con=JdbcUtill.getConnection();
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, email);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("중복된 이메일 있음");
				return true;
			}else {
				System.out.println("중복된 이메일 없음");
				return false;
			}
			
			
		} catch (SQLException e) {
			System.out.println("이메일 중복검사 오류");
			e.printStackTrace();
		}
		
		return false;
	}

}
