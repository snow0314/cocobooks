package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import bean.AllChargeList;
import common.JdbcUtill;

public class AllChargeListDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public AllChargeListDao() {
		con=JdbcUtill.getConnection();
	}
	public void close() {
		JdbcUtill.close(rs, pstmt, con);
	}
	public List<AllChargeList> allList(String id) {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String sql="SELECT RANK,CR_NUM,CR_ID,CR_PRICE,CR_DATE\r\n" + 
				"FROM\r\n" + 
				"(SELECT ROWNUM RANK,CR_NUM,CR_ID,CR_PRICE,CR_DATE\r\n" + 
				"FROM (SELECT CR_NUM,CR_ID,CR_PRICE,CR_DATE FROM CHARGE\r\n" + 
				"      where CR_id=?\r\n" + 
				"      ORDER BY CR_NUM ))\r\n" + 
				"WHERE CR_ID=?";
		List<AllChargeList> allCList=new ArrayList<AllChargeList>();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, id);
			pstmt.setNString(2, id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				System.out.println("충전내역 와일문 안으로 들어옴");
				AllChargeList allList=new AllChargeList();
				allList.setChargeNum(rs.getInt("RANK"));
				allList.setChargeId(rs.getNString("CR_ID"));
				allList.setChargePrice(rs.getInt("CR_PRICE"));
				String crDate=sdf.format(rs.getTimestamp("CR_DATE"));
				allList.setChargeDate(crDate);
				allCList.add(allList);
			}
			return allCList;
		} catch (SQLException e) {
			System.out.println("충전 내역 보기 예외");
			e.printStackTrace();
		}
	
		return allCList;
	}
}
