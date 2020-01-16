package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.FaideWebFictionBean;
import bean.Forward;
import bean.Story;
import common.JdbcUtill;

public class FreeWebFictionDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public FreeWebFictionDao() {
		con=JdbcUtill.getConnection();
	}
	public void close() {
		JdbcUtill.close(rs, pstmt, con);
	}
	public List<FaideWebFictionBean> freeWebFictionList() {
		List<FaideWebFictionBean> fwfList=null;
		String sql="SELECT nb.NO_NUM,nb.NO_ID,nb.NO_TITLE,nb.NO_INTRO,nb.NO_GRADE,ge.GE_NAME,COUNT(re.RT_STORY_NUM) LIKECOUNT\r\n" + 
				"from nobel nb INNER join GENRE ge on nb.NO_GENRE_NUM=ge.GE_NUM \r\n" + 
				"LEFT join story sr on nb.NO_NUM=sr.SR_NOBEL_NUM \r\n" + 
				"LEFT join RECOMMENDATION re on sr.SR_NUM=re.RT_STORY_NUM\r\n" + 
				"where nb.PAY_N_FREE='무료'\r\n" + 
				"GROUP by nb.NO_NUM,nb.NO_ID,nb.NO_TITLE,nb.NO_INTRO,nb.NO_GRADE,ge.GE_NAME,sr.SR_NOBEL_NUM ORDER by nb.NO_NUM";
		try {
			fwfList=new ArrayList<FaideWebFictionBean>();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
			FaideWebFictionBean fwf=new FaideWebFictionBean();
			fwf.setNovel_num(rs.getInt("NO_NUM"));
			fwf.setUser_id(rs.getNString("NO_ID"));
			fwf.setTitle(rs.getNString("NO_TITLE"));
			fwf.setIntro(rs.getNString("NO_INTRO"));
			fwf.setGrade(rs.getNString("NO_GRADE"));
			fwf.setGenre(rs.getNString("GE_NAME"));
			fwf.setLike(rs.getInt("LIKECOUNT"));
			fwfList.add(fwf);
			}
			return fwfList;
		} catch (SQLException e) {
			System.out.println("무료웹 소설 불러오기 예외");
			e.printStackTrace();
		}
		
		return fwfList;
	}
	}
		