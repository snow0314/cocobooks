package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Member;
import common.JdbcUtill;

public class AuthorDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public List<Member> authorShow() {
		String sql="SELECT member.mb_id, member.mb_name, member.mb_age, member.mb_gender,member.mb_email,SUM(STORY.SR_VIEW_NUM) \r\n" + 
				"FROM MEMBER\r\n" + 
				"JOIN STORY\r\n" + 
				"ON member.mb_id=story.sr_id\r\n" + 
				"WHERE MB_APPLY='신청'\r\n" + 
				"GROUP BY member.mb_id, member.mb_age, member.mb_name, member.mb_gender, member.mb_email";
				
		List<Member> mbList=new ArrayList<Member>();
		con=JdbcUtill.getConnection();
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Member mb=new Member();
				mb.setId(rs.getNString("MB_ID"));
				mb.setName(rs.getNString("MB_NAME"));
				mb.setAge(rs.getInt("MB_AGE"));
				mb.setGender(rs.getNString("MB_GENDER"));
				mb.setEmail(rs.getNString("MB_EMAIL"));
				mb.setTotalView(rs.getInt("SUM(STORY.SR_VIEW_NUM)"));
				mbList.add(mb);
			}
			
			System.out.println("전환신청한 작가들 보임 ");
			JdbcUtill.close(rs, pstmt, con);
		} catch (SQLException e) {
			System.out.println("전환신청한 작가들 오류 ");
			e.printStackTrace();
		}
		
		return mbList;
	}

	public boolean authorchange(String id) {
		String sql="UPDATE MEMBER\r\n" + 
				"SET MB_APPLY='완료'\r\n" + 
				"WHERE MB_ID=?";
		con=JdbcUtill.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, id);
			int result=pstmt.executeUpdate();
			System.out.println("전환3");
			
		String sql2="UPDATE MEMBER\r\n" + 
				"SET MB_KIND_NUM='유료'\r\n" + 
				"WHERE MB_ID=?"	;
			pstmt=con.prepareStatement(sql2);
			pstmt.setNString(1, id);
			result=pstmt.executeUpdate();
			System.out.println("전환4");
			
			if(result!=0) {
				System.out.println("전환성공");
				return true;
			}else {
				System.out.println("전환실패");
				return false;
			}
			
		} catch (SQLException e) {
			System.out.println("전환오류");
			e.printStackTrace();
		}
		
		return false;
	}

}
