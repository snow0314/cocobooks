package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JdbcUtill;

public class NovelGradeChangeDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public boolean novelgradechange(int novelNum) {
		String sql = "SELECT * FROM NOBEL WHERE NO_NUM=?";
		con = JdbcUtill.getConnection();
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, novelNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				if (rs.getNString("NO_GRADE").equals("일반")) {
					String sql2 = "UPDATE NOBEL\r\n" + "SET NO_GRADE='성인'\r\n" + "WHERE NO_NUM=?";
					pstmt = con.prepareStatement(sql2);
					pstmt.setInt(1, novelNum);
					result = pstmt.executeUpdate();

				} else if (rs.getNString("NO_GRADE").equals("성인")) {
					String sql2 = "UPDATE NOBEL\r\n" + "SET NO_GRADE='일반'\r\n" + "WHERE NO_NUM=?";
					pstmt = con.prepareStatement(sql2);
					pstmt.setInt(1, novelNum);
					result = pstmt.executeUpdate();
				}
			}
			if (result != 0) {
				System.out.println("등급 전환 성공");
				return true;
			} else {
				System.out.println("등급 전환 실패");
				return false;
			}

		} catch (SQLException e) {
			System.out.println("등급 전환 오류");
			e.printStackTrace();
		}

		return false;
	}

}
