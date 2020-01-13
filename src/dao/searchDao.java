package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.FaideWebFictionBean;
import common.JdbcUtill;

public class searchDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public searchDao() {
		con=JdbcUtill.getConnection();
	}
	public void close() {
		JdbcUtill.close(rs, pstmt, con);
	}
	public List<FaideWebFictionBean> search(String[] searchValue) {
		List<FaideWebFictionBean> fWebFList=null;
		String sql=null;
		try {
		if(searchValue[0].equals("번호")) {
			sql="SELECT * FROM WEB_PAY_LIST WHERE NO_NUM=?";
		}else if(searchValue[0].equals("작가")) {
			sql="SELECT * FROM WEB_PAY_LIST WHERE NO_ID=?";
		}else if(searchValue[0].equals("제목")) {
			sql="SELECT * FROM WEB_PAY_LIST WHERE NO_TITLE=?";
		}else if(searchValue[0].equals("장르")) {
			sql="SELECT * FROM WEB_PAY_LIST WHERE GE_NAME=?";
		}
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, searchValue[1]);
			rs=pstmt.executeQuery();
			fWebFList=new ArrayList<FaideWebFictionBean>();
			while (rs.next()) {
				FaideWebFictionBean fWebFBean= new FaideWebFictionBean();
				fWebFBean.setNovel_num(rs.getInt("NO_NUM"));
				fWebFBean.setUser_id(rs.getNString("NO_ID"));
				fWebFBean.setTitle(rs.getNString("NO_TITLE"));
				fWebFBean.setIntro(rs.getNString("NO_INTRO"));
				fWebFBean.setGrade(rs.getNString("NO_GRADE"));
				fWebFBean.setGenre(rs.getNString("GE_NAME"));
				fWebFBean.setLike(rs.getInt("LIKECOUNT"));
				fWebFList.add(fWebFBean);
			}
			return fWebFList;
		} catch (SQLException e) {
			System.out.println("검색 불러오기 예외");
			e.printStackTrace();
		}
		return fWebFList;
	}

}
