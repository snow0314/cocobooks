package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Novel;
import common.JdbcUtill;

public class AllNovelShowDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	public List<Novel> allnovelshow() {
		String sql="SELECT * FROM NOBEL";
		List<Novel> nlist=new ArrayList<Novel>();
		con=JdbcUtill.getConnection();
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Novel nv=new Novel();
				nv.setId(rs.getNString("NO_ID"));
				nv.setTitle(rs.getNString("NO_TITLE"));
				nv.setGrade(rs.getNString("NO_GRADE"));
				nv.setNovel_num(rs.getInt("NO_NUM"));
				nlist.add(nv);
			}
			JdbcUtill.close(rs, pstmt, con);
			System.out.println("모든 작품 리스트 불러오기 성공");
			
		} catch (SQLException e) {
			System.out.println("모든 작품 리스트 불러오기 오류");
			e.printStackTrace();
		}
		
		return nlist;
	}

}
