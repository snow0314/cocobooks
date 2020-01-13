package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Novel;
import common.JdbcUtill;

public class NovelDetailDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public Novel novelDetailShow(int novelNum) {
		Novel novel=new Novel();
		String sql="SELECT * FROM NOBEL \r\n" + 
				"JOIN GENRE\r\n" + 
				"ON nobel.no_genre_num=genre.ge_num\r\n" + 
				"WHERE NO_NUM=?";
		con=JdbcUtill.getConnection();
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, novelNum);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				novel.setNovel_num(rs.getInt("NO_NUM"));
				novel.setId(rs.getNString("NO_ID"));
				novel.setTitle(rs.getNString("NO_TITLE"));
				novel.setIntro(rs.getNString("NO_TITLE"));
				novel.setGrade(rs.getNString("NO_GRADE"));
				novel.setGenre(rs.getNString("GE_NAME"));
				novel.setPay_n_free(rs.getNString("PAY_N_FREE"));
			}
			
			return novel;
			
		} catch (SQLException e) {
			System.out.println("작품 상세 목록 오류");
			e.printStackTrace();
		}
		
		
		return novel;
	}

}
