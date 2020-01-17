package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import common.JdbcUtill;

public class UserBoardDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

public UserBoardDao() {
	con=JdbcUtill.getConnection();
}
public void close() {
	JdbcUtill.close(rs, pstmt, con);
}

public boolean userWrite(String id, String title, String contents) {
	String sql="INSERT INTO USER_BOARD"+ "(UB_NUM,UB_ID,UB_TITLE,UB_CONTENTS,UB_DATE,UB_VIEW_NUM)"
			+"VALUES (UB_NUM_SEQ.nextval, ?,?,?,sysdate,0)";
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setNString(1, id);
				pstmt.setNString(2, title);
				pstmt.setNString(3, contents);
				int result=pstmt.executeUpdate();
				
				if(result!=0) {
					System.out.println("성공");
					return true;
				}
				
			}catch(SQLException e) {
			e.printStackTrace();
		}		
			return false;
	}


}