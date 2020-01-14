package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Story;
import common.JdbcUtill;

public class ViewerDao {
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//유료인지 무료인지 검사하는 메소드
	public boolean kindCheck(int num) {
		String sql="SELECT *\r\n" + 
				"FROM NOBEL\r\n" + 
				"JOIN STORY\r\n" + 
				"ON nobel.no_num=story.sr_nobel_num\r\n" + 
				"WHERE SR_NUM=?";
		
		con=JdbcUtill.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				if("유료".equals(rs.getNString("PAY_N_FREE"))) {
					return true;
				}else {
					return false;
				}
			}
			
		} catch (SQLException e) {
			System.out.println("유료,무료 체크 오류");
			e.printStackTrace();
		}
		
		return false;
	}
	
	//해당 작품을 구매했는지 체크하는 메소드
	public boolean paidCheck(String id, int story_num) {
		String sql="SELECT * FROM PAY_LIST WHERE PL_ID=? AND PL_STORY_NUM=?";
		con=JdbcUtill.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, id);
			pstmt.setInt(2, story_num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("이미 구매한 작품");
				return true;
			}else {
				System.out.println("작품을 구매하세요");
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Story read(int story_num) {
		String sql="SELECT * FROM STORY WHERE SR_NUM=?";
		con=JdbcUtill.getConnection();
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, story_num);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				Story st=new Story();
				st.setSR_CONTENTS(rs.getNString("SR_CONTENTS"));
				st.setSR_NOBLE_NUM(rs.getInt("SR_NOBEL_NUM"));
				
				String sql2="SELECT STORY.SR_NUM,COUNT(rt_story_num)\r\n" + 
						"FROM STORY\r\n" + 
						"JOIN recommendation\r\n" + 
						"ON story.sr_num=recommendation.rt_story_num\r\n" + 
						"WHERE SR_NUM=?\r\n" + 
						"GROUP BY STORY.SR_NUM";
				pstmt=con.prepareStatement(sql2);
				pstmt.setInt(1, story_num);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					st.setRec(rs.getInt("COUNT(rt_story_num)"));
				}
				return st;
			}
			
			
		} catch (SQLException e) {
			System.out.println("오류가 나는구나");
			e.printStackTrace();
		}
		
		return null;
	}
	
	

}
