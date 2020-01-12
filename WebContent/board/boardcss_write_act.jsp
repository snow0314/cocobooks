<%@ page language="java" import="java.sql.*,java.util.*,java.io.*,util.*" contentType="text/html;charset=euc-kr" %>
<%@ page import = "oracle.sql.CLOB" %>

<%!
	Connection DB_Connection() throws ClassNotFoundException, SQLException, Exception
	{
		String url = "jdbc:oracle:thin:@xxx.xxx.xxx.xxx:1521:ORA2012";
		String username = "study";
		String userpass = "study";
		Class.forName( "oracle.jdbc.driver.OracleDriver" );
		Connection conn = DriverManager.getConnection( url, username, userpass );
		return conn;
	}
%>

<%
	Connection conn = DB_Connection();
	Statement stmt = null;
	ResultSet rs = null;
	StringBuffer query = null;

	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");

	try
	{
		stmt = conn.createStatement();
		query = new StringBuffer();

		String seq = "";

		query.setLength(0);
		query.append("SELECT NEWBOARD_SEQ.NEXTVAL AS SEQ FROM DUAL");
		rs = stmt.executeQuery(query.toString());
		if (rs.next()) {
			seq = rs.getString("SEQ");
		}
		rs.close();

		query.setLength(0);
		query.append("INSERT INTO NEWBOARD ( SEQ, NAME, SUBJECT, CONTENTS )")
				.append("VALUES ( '"+seq+"', '"+name+"', '"+subject+"', empty_clob() )");
		stmt.executeUpdate(query.toString());

		conn.setAutoCommit(false); 

		query.setLength(0);
		query.append("SELECT CONTENTS FROM NEWBOARD WHERE SEQ= '"+seq+"' FOR UPDATE ");

		rs = stmt.executeQuery( query.toString() );
		if ( rs.next() )
		{
			CLOB clob = (CLOB)rs.getClob(1);
			Writer writer = clob.getCharacterOutputStream();
			Reader src = new CharArrayReader(contents.toCharArray());
			char[] buffer = new char[1024];
			int read = 0;
			while ( (read = src.read(buffer,0,1024)) != -1) {
				writer.write(buffer, 0, read);
			}
			src.close();
			writer.close();

			conn.commit();
			conn.setAutoCommit(true);
		}

	} catch( Exception e ) {
		out.println( e.toString() );
	}

	out.println("<SCRIPT>alert(\"게시판에 글을 등록하였습니다. \");</script>");
	out.println("<SCRIPT>parent.opener.location.href='/boardCSS/boardcss_list.jsp';</SCRIPT>");
	out.println("<SCRIPT>parent.close();</SCRIPT>");
%>
