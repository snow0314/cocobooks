package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.UserBoard;
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
public List<UserBoard> userview() {
	String sql="SELECT * FROM USER_BOARD";
	try {
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		List<UserBoard> list=new ArrayList<UserBoard>();
		
		while(rs.next()) {
			UserBoard ub=new UserBoard();
			ub.setUB_ID(rs.getNString("UB_ID"));
			ub.setUB_TITLE(rs.getNString("UB_TITLE"));
			ub.setUB_NUM(rs.getInt("UB_NUM"));
			ub.setUB_CONTENTS(rs.getNString("UB_CONTENTS"));
			ub.setUB_VIEW(rs.getInt("UB_VIEW_NUM"));
			ub.setUB_DATE(rs.getDate("UB_DATE"));
			list.add(ub);
		}
		return list;
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return null;
}

}