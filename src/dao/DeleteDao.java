package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JdbcUtill;

public class DeleteDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;


public int deleteMember(String id, String pw) 
{
	String sql="DELETE FROM MEMBER WHERE MB_ID=? AND MB_PW=? ";
	con = JdbcUtill.getConnection();
    try {
    	pstmt=con.prepareStatement(sql);
    	pstmt.setNString(1, id);
    	pstmt.setNString(2, pw);
        int result=pstmt.executeUpdate();
        
        if(result!=0) {
        	System.out.println("회원탈퇴 성공");
        	return 1;
        }else {
        	System.out.println("회원탈퇴 실패");
        	return -1;
        }
       }catch (Exception e) {
	System.out.println("탈퇴 오류");
	e.printStackTrace();
} // end deleteMember
    return 0;
}
}
