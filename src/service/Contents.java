package service;

import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import bean.BuyListBean;
import dao.BuyListDao;

public class Contents {
	HttpServletRequest request;
	HttpServletResponse response;
	public Contents(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
	public String buyList() {
		String json=null;
		HttpSession session= request.getSession();
		String id=(String) session.getAttribute("id");
		BuyListDao bDao=new BuyListDao();
		System.out.println(id);
		List<BuyListBean> bList= bDao.buyList(id);
		
		if(bList!=null&&bList.size()!=0) {
			Gson gson=new Gson();
			Type shapeType = new TypeToken<List <BuyListBean>>() {}.getType(); 
			json=gson.toJson(bList,shapeType);
			System.out.println("구매목록 불러오기 성공");
			return json;
		}
		System.out.println("구매목록 불러오기 실패");
		bDao.close();
		return json;

	}

	
	
}
