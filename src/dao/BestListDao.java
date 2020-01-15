package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.NovelList;
import common.JdbcUtill;

public class BestListDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public BestListDao() {
		con=JdbcUtill.getConnection();
	}
	public void close() {
		JdbcUtill.close(rs, pstmt, con);
	}
	public List<NovelList> freeList() {
		List<NovelList> list=null;
		String sql="SELECT NB.NO_NUM,NB.NO_TITLE,NB.NO_ID,NVL(SUM(SR.SR_VIEW_NUM),0) TOTALVIEW\r\n" + 
				"FROM NOBEL NB LEFT JOIN STORY SR\r\n" + 
				"ON NB.NO_NUM=SR.SR_NOBEL_NUM\r\n" + 
				"where PAY_N_FREE='무료'\r\n" + 
				"group by NB.NO_NUM, NB.NO_TITLE, NB.NO_ID\r\n" + 
				"ORDER BY NVL(SUM(SR.SR_VIEW_NUM),0 ) DESC";
			try {
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				list=new ArrayList<NovelList>();
				while(rs.next()) {
					NovelList nl=new NovelList();
					nl.setNum(rs.getInt("NO_NUM"));
					nl.setTitle(rs.getNString("NO_TITLE"));
					nl.setId(rs.getNString("NO_ID"));
					nl.setTotalView(rs.getInt("TOTALVIEW"));
					list.add(nl);
				}
				return list;
			} catch (SQLException e) {
				System.out.println("무료 베스트 웹 예외");
				e.printStackTrace();
			}
			
		return list;
	}
	
	public List<NovelList> payList() {
		List<NovelList> list=null;
		String sql="SELECT NB.NO_NUM,NB.NO_TITLE,NB.NO_ID,NVL(SUM(SR.SR_VIEW_NUM),0) TOTALVIEW\r\n" + 
				"FROM NOBEL NB LEFT JOIN STORY SR\r\n" + 
				"ON NB.NO_NUM=SR.SR_NOBEL_NUM\r\n" + 
				"where PAY_N_FREE='유료'\r\n" + 
				"group by NB.NO_NUM, NB.NO_TITLE, NB.NO_ID\r\n" + 
				"ORDER BY NVL(SUM(SR.SR_VIEW_NUM),0 ) DESC";
			try {
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				list=new ArrayList<NovelList>();
				while(rs.next()) {
					NovelList nl=new NovelList();
					nl.setNum(rs.getInt("NO_NUM"));
					nl.setTitle(rs.getNString("NO_TITLE"));
					nl.setId(rs.getNString("NO_ID"));
					nl.setTotalView(rs.getInt("TOTALVIEW"));
					list.add(nl);
				}
				return list;
			} catch (SQLException e) {
				System.out.println("유료 베스트 웹 예외");
				e.printStackTrace();
			}
			
		return list;
	}
}
