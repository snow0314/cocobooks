package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Novel;
import common.JdbcUtill;

public class MyNovelDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MyNovelDao() {
		con=JdbcUtill.getConnection();
	}
	public void close() {
		JdbcUtill.close(rs, pstmt, con);
	}
	public List<Novel> getList(String id) {
		List<Novel> myNovelList=null;
		String sql= "SELECT nb.NO_NUM,nb.NO_TITLE,ge.GE_NAME\r\n" + 
				"from NOBEL nb \r\n" + 
				"INNER join GENRE ge on nb.NO_GENRE_NUM=ge.GE_NUM\r\n" + 
				"where nb.NO_ID=?\r\n" + 
				"ORDER by nb.NO_NUM desc";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs=pstmt.executeQuery();
			myNovelList= new ArrayList<Novel>();
			while(rs.next()) {
				Novel nv= new Novel();
				nv.setNovel_num(rs.getInt("NO_NUM"));
				nv.setTitle(rs.getNString("NO_TITLE"));
				nv.setGenre(rs.getNString("GE_NAME"));
				myNovelList.add(nv);
			}
			return myNovelList;
		} catch (SQLException e) {
			System.out.println("내작품 불러오기 실패");
			e.printStackTrace();
		}
		
		return myNovelList;
	}

}
