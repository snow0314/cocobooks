package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import common.JdbcUtill;

public class TotalSearchDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public TotalSearchDao() {
		con=JdbcUtill.getConnection();
	}
	public void close() {
		JdbcUtill.close(rs, pstmt, con);
	}
	public List<LinkedHashMap<String, Object>> totalSearch(String val) {
		
		List<LinkedHashMap<String, Object>> list = new ArrayList<LinkedHashMap<String, Object>>();
		String sql="\r\n" + 
				"SELECT nb.NO_NUM,nb.NO_TITLE,nb.NO_ID,COUNT(re.RT_STORY_NUM) LIKECOUNT,nb.PAY_N_FREE\r\n" + 
				"from nobel nb INNER join GENRE ge on nb.NO_GENRE_NUM=ge.GE_NUM \r\n" + 
				"LEFT join story sr on nb.NO_NUM=sr.SR_NOBEL_NUM \r\n" + 
				"LEFT join RECOMMENDATION re on sr.SR_NUM=re.RT_STORY_NUM\r\n" + 
				"where nb.NO_TITLE like '%'||?||'%' or nb.NO_ID like '%'||?||'%'\r\n" + 
				"GROUP by nb.NO_NUM, nb.NO_ID, nb.NO_TITLE, nb.NO_GRADE, \r\n" + 
				"sr.SR_NOBEL_NUM, nb.PAY_N_FREE\r\n" + 
				"ORDER by nb.NO_NUM";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, val);
			pstmt.setNString(2, val);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				LinkedHashMap<String, Object> lHmap= new LinkedHashMap<String, Object>();
				lHmap.put("num", rs.getInt("NO_NUM"));
				lHmap.put("title", rs.getNString("NO_TITLE"));
				lHmap.put("id", rs.getNString("NO_ID"));
				lHmap.put("like", rs.getInt("LIKECOUNT"));
				lHmap.put("pNf", rs.getNString("PAY_N_FREE"));
				System.out.println("와일문 안에서 맵"+ lHmap);
				list.add(lHmap);
			}
			return list;
		} catch (SQLException e) {
			System.out.println("통합검색 예외");
			e.printStackTrace();
		}
		return list;
	}
}
