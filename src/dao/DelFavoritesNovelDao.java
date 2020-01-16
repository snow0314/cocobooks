package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JdbcUtill;

public class DelFavoritesNovelDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public DelFavoritesNovelDao() {
		con=JdbcUtill.getConnection();
	}
	public void close() {
		JdbcUtill.close(rs, pstmt, con);
	}

	public boolean del(String id, int delnum) {
		String sql="DELETE FROM PREFERENCE WHERE PR_ID=? AND PR_NOBEL_NUM=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, id);
			pstmt.setInt(2, delnum);
			int result=pstmt.executeUpdate();
			if(result!=0) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("선호작 삭제 예외");
			e.printStackTrace();
		}
		
		return false;
	}

}
