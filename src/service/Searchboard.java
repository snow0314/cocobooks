package service;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Forward;
import dao.TotalSearchDao;

public class Searchboard {
	HttpServletRequest request;
	HttpServletResponse response;
	public Searchboard(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
	public Forward totalSearch() {
		Forward fw= new Forward();
		String val=request.getParameter("search_box");
		TotalSearchDao totDao= new TotalSearchDao();
		List<LinkedHashMap<String, Object>> totdata=totDao.totalSearch(val);
		if(totdata!=null&&totdata.size()!=0) {
			request.setAttribute("data", makeHtml(totdata));
			fw.setPath("totalSearch.jsp");
			fw.setRedirect(false);
			return fw;
		}else {
			request.setAttribute("data","<tr><td></td><td></td><td>검색결과가 없습니다.</td><td></td><td></td></tr>");
			fw.setPath("totalSearch.jsp");
			fw.setRedirect(false);
		}
		return fw;
	}
	
	private String makeHtml(List<LinkedHashMap<String, Object>> totdata) {
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<totdata.size();i++) {
			sb.append("<tr>");
			sb.append("<td>"+totdata.get(i).get("num")+"</td>");
			sb.append("<input type='hidden' name='novelNum' class='storynum' value="+totdata.get(i).get("num")+">");			
			sb.append("<td><input type='button' value='"+totdata.get(i).get("title")+"' class='borderList' onclick='submitt("+totdata.get(i).get("num")+")'></td>");
			sb.append("<td>"+totdata.get(i).get("id")+"</td>");
			sb.append("<td>"+totdata.get(i).get("like")+"</td>");
			sb.append("<td>"+totdata.get(i).get("pNf")+"</td>");
			sb.append("</tr>");
		}		
		return sb.toString();
	}

}
