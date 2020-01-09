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

    String dbpw = ""; // DB상의 비밀번호를 담아둘 변수
    int x = -1;
      
    try {
        // 비밀번호 조회
        StringBuffer query1 = new StringBuffer();
        query1.append("SELECT PASSWORD FROM JSP_MEMBER WHERE ID=?");

        // 회원 삭제
        StringBuffer query2 = new StringBuffer();
        query2.append("DELETE FROM JSP_MEMBER WHERE ID=?");

        con = JdbcUtill.getConnection();

        
        // 1. 아이디에 해당하는 비밀번호를 조회한다.
        pstmt = con.prepareStatement(query1.toString());
        pstmt.setString(1, id);
        rs = pstmt.executeQuery();

        if (rs.next()) 
        {
            dbpw = rs.getString("password");
            if (dbpw.equals(pw)) // 입력된 비밀번호와 DB비번 비교
            {
                // 같을경우 회원삭제 진행
                pstmt = con.prepareStatement(query2.toString());
                pstmt.setString(1, id);
                pstmt.executeUpdate();
                con.commit(); 
                x = 1; // 삭제 성공
            } else {
                x = 0; // 비밀번호 비교결과 - 다름
            }
        }

        return x;

    } catch (Exception sqle) {
        try {
            con.rollback(); // 오류시 롤백
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException(sqle.getMessage());
    } finally {
        try{
            if ( pstmt != null ){ pstmt.close(); pstmt=null; }
            if ( con != null ){ con.close(); con=null;    }
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
} // end deleteMember

	}
