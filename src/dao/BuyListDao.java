package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import bean.BuyListBean;
import common.JdbcUtill;

public class BuyListDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public BuyListDao() {
		con=JdbcUtill.getConnection();
	}
	public void close() {
		JdbcUtill.close(rs, pstmt, con);
	}
	public List<BuyListBean> buyList(String id) {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh:mm");
		List<BuyListBean> bList=null;
		try {
			String sql="SELECT * FROM BUY_LIST_VIEW WHERE PL_ID=?";
			bList=new ArrayList<BuyListBean>();
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BuyListBean buyListBean= new BuyListBean();
				buyListBean.setBuyId(rs.getNString("PL_ID"));
				buyListBean.setStoryNum(rs.getInt("PL_STORY_NUM"));
				String buyListDate=sdf.format(rs.getTimestamp("PL_DATE"));
				buyListBean.setBuyDate(buyListDate);
				buyListBean.setPrice(rs.getInt("PL_PRICE"));
				buyListBean.setStoryTitle(rs.getNString("SR_TITLE"));
				buyListBean.setNovelTitle(rs.getNString("NO_TITLE"));
				bList.add(buyListBean);
			}
			return bList;
		} catch (SQLException e) {
			System.out.println("구매목록 예외");
			e.printStackTrace();
		}
		return bList;
	}
}
