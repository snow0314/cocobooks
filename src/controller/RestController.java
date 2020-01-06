package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RestController")
public class RestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd=request.getServletPath();
		String json=null; //제이슨 받을 문자열 변수
		
		switch (cmd) {
		case "value":
			System.out.println("수정합니다");
			break;

		default:
			break;
		}
		
		
		if(json!=null) { //제이슨 반환
			response.setContentType("test/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.write(json);
		}
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
