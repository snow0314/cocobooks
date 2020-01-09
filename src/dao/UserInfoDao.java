package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Member;
import common.JdbcUtill;


public class UserInfoDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	
	public List<Member> allUserInfo() {
		String sql="SELECT * FROM MEMBER";
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
				mb.setKind(rs.getNString("MB_KIND_NUM"));
				mb.setCoin(rs.getInt("MB_COIN"));
				mbList.add(mb);
			}
			JdbcUtill.close(rs, pstmt, con);
			System.out.println("모든 회원 보기 성공");
			
			
		} catch (SQLException e) {
			System.out.println("모든 회원 보기 오류");
			e.printStackTrace();
		}
		
		return mbList;
		
		
	}

}
