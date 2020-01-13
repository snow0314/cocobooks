package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.FaideWebFictionBean;
import common.JdbcUtill;

public class FaideWebFictionDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public FaideWebFictionDao() {
		con=JdbcUtill.getConnection();
	}
	public void close() {
		JdbcUtill.close(rs, pstmt, con);
	}
	public List<FaideWebFictionBean> FaideWebFictionList() {
		List<FaideWebFictionBean> fwfList=null;
		String sql="SELECT * FROM WEB_PAY_LIST";
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
			System.out.println("유료웹 소설 불러오기 예외");
			e.printStackTrace();
		}
		
		return fwfList;
	}
	
}
