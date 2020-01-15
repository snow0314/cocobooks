package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JdbcUtill;

public class PreferenceActionDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public boolean preferenceAdd(String id, int num) {
		String sql="INSERT INTO PR VALUES(?,?)";
		con=JdbcUtill.getConnection();
		int result=0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, id);
			pstmt.setInt(2, num);
			result=pstmt.executeUpdate();
			
			if(result!=0) {
				return true;
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			System.out.println("선호작 등록 오류");
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean preferenceCheck(String id, int num) {
		String sql="SELECT * FROM PR WHERE PR_ID=? AND PR_NOBEL_NUM=?";
	
		con=JdbcUtill.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, id);
			pstmt.setInt(2, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) { //이미 그 작품을 선호작 등록했으면 false
				return false;
			}else { //선호작 등록이 안되어 있으면 true를 리턴
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("선호작 체크 오류");
			e.printStackTrace();
		}

		return false;
	}

}
