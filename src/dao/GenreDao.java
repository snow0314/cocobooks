package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JdbcUtill;

public class GenreDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public List<String> genreShow() {
		String sql="SELECT GE_NAME FROM GENRE";
		List<String> list=new ArrayList<String>();
		con=JdbcUtill.getConnection();
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getNString("GE_NAME"));
			}
			JdbcUtill.close(rs, pstmt, con);		
			System.out.println("장르 보기 성공");
			return list;
			
		} catch (SQLException e) {
			System.out.println("장르 보기 오류");
			e.printStackTrace();
		}
		
		return list;
	}

}
