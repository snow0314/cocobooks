package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Story;
import common.JdbcUtill;

public class paidCheckDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public List<Story> paidCheck(String id, int num) {
		String sql="SELECT PL_ID,PL_STORY_NUM,NO_NUM \r\n" + 
				"FROM PAY_LIST\r\n" + 
				"JOIN STORY\r\n" + 
				"ON pay_list.pl_story_num=story.sr_num\r\n" + 
				"JOIN NOBEL\r\n" + 
				"ON nobel.no_num=story.sr_nobel_num\r\n" + 
				"WHERE PL_ID=? AND NO_NUM=?";
		List<Story> list=new ArrayList<Story>();
		
		con=JdbcUtill.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, id);
			pstmt.setInt(2, num);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Story st=new Story();
				st.setSR_ID(rs.getNString("PL_ID"));
				st.setSR_NUM(rs.getInt("PL_STORY_NUM")); //글 번호
				st.setSR_NOBLE_NUM(rs.getInt("NO_NUM")); //작품 번호
				list.add(st);
			}
			return list;
			
		} catch (SQLException e) {
			System.out.println("paidCheck 오류");
			e.printStackTrace();
		}
		
		return null;
	}

}
