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
		String sql="SELECT * FROM MEMBER WHERE MB_APPLY='신청'";
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
				mb.setBlackList(rs.getInt("MB_BLACKLIST"));
				mb.setApply(rs.getNString("MB_APPLY"));
				mbList.add(mb);
			}
			JdbcUtill.close(rs, pstmt, con);
			System.out.println("전환신청한 작가들 보임 ");
			
		} catch (SQLException e) {
			System.out.println("전환신청한 작가들 오류 ");
			e.printStackTrace();
		}
		
		return mbList;
	}

}
