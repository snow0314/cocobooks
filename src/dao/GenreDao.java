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

	public int genereDelete(String name) {
		String sql="DELETE FROM GENRE WHERE GE_NAME=?";
		con=JdbcUtill.getConnection();
		System.out.println("장르이름="+name);
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, name);
			int result=pstmt.executeUpdate();
			
			if(result!=0) {
				System.out.println("장르 삭제 성공");
				return 1;
			}else {
				System.out.println("장르 삭제 실패");
				return 0;
			}
			
		} catch (SQLException e) {
			System.out.println("장르 삭제 오류");
			e.printStackTrace();
		}
		
		JdbcUtill.close(rs, pstmt, con);		
		return 0;
	}

	public int genreAdd(String name) {
		String sql="INSERT INTO GENRE VALUES(GE_NUM_SEQ.NEXTVAL,?)";
		con=JdbcUtill.getConnection();
		System.out.println("장르이름="+name);
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, name);
			int result=pstmt.executeUpdate();
			
			if(result!=0) {
				System.out.println("장르 추가 성공");
				return 1;
			}else {
				System.out.println("장르 추가 실패");
				return 0;
			}
			
		} catch (SQLException e) {
			System.out.println("장르 추가 오류");
			e.printStackTrace();
		}
		
		JdbcUtill.close(rs, pstmt, con);	
		
		return 0;
	}

}
