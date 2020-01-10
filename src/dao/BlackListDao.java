package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Member;
import common.JdbcUtill;

public class BlackListDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public List<Member> blacklistshow() {
		String sql="SELECT * FROM MEMBER WHERE MB_BLACKLIST=1";
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
				mbList.add(mb);
			}
			JdbcUtill.close(rs, pstmt, con);
			System.out.println("블랙리스트 회원 보기 성공");
			
		} catch (SQLException e) {
			System.out.println("블랙리스트 회원 보기 오류");
			e.printStackTrace();
		}
		
		
		
		return mbList;
	}

	public boolean blackListDelete(String[] black) {
		String sql="UPDATE MEMBER SET MB_BLACKLIST=0 WHERE MB_ID=?";
		con=JdbcUtill.getConnection();
		int result=0;
		
		try {
			pstmt=con.prepareStatement(sql);
			
				for(int i=0;i<black.length;i++) {
					System.out.println("블랙리스트 포문");
					System.out.println("블랙원:"+black[i]);
					pstmt.setNString(1, black[i]);
					result=pstmt.executeUpdate();
				}
			JdbcUtill.close(rs, pstmt, con);
			System.out.println("블랙리스트 해제 성공");
			
			if(result!=0) {
				return true;
			}else {
				return false;
			}
			
			
		} catch (SQLException e) {
			System.out.println("블랙리스트 해제 오류");
			e.printStackTrace();
		}
		
		return false;
	}

}
