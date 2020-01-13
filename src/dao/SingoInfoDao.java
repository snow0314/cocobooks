package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Declaration;
import common.JdbcUtill;

public class SingoInfoDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public List<Declaration> singoinfo() {
		String sql="SELECT * FROM DECLARATION";
		con=JdbcUtill.getConnection();
		List<Declaration> dlist=new ArrayList<Declaration>();
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Declaration de=new Declaration();
				de.setStory_num(rs.getInt("DT_STORY_NUM"));
				de.setName(rs.getNString("DT_NAME"));
				de.setId(rs.getNString("DT_ID"));
				de.setCartegory(rs.getNString("DT_REPORT_CARTEGORY"));
				de.setDiteil(rs.getNString("DT_REPORT_DITEIL"));
				dlist.add(de);
			}
			JdbcUtill.close(rs, pstmt, con);
			System.out.println("모든 신고받은 글 보기 성공");
			
		} catch (SQLException e) {
			System.out.println("모든 신고받은 글 보기 오류");
			e.printStackTrace();
		}
		
		return dlist;
	}

}
