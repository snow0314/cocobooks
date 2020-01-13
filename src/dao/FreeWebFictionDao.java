package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Forward;
import bean.Story;
import common.JdbcUtill;

public class FreeWebFictionDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public boolean write(Story story) {
		String sql = "INSERT INTO STORY VALUES(SR_NUM_SEQ.NEXTVAL,1,?,?,?,DEFAULT,SYSDATE,DEFAULT)";
		con = JdbcUtill.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			int result;
			result = pstmt.executeUpdate();
			if (result == 0) {
				System.out.println("게시판 등록 실패");
				return false;
			}
			System.out.println("게시판 등록 완료");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	}
		