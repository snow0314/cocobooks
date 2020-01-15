package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Forward;
import bean.NovelList;
import dao.BestListDao;

public class BestPayWebNovel {

	HttpServletRequest request;
	HttpServletResponse response;
	public BestPayWebNovel(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
	public Forward freeWeblist() {
		Forward fw= new Forward();
		BestListDao bDao= new BestListDao();
		List<NovelList> payList=bDao.payList();
		if(payList!=null&&payList.size()!=0) {
			System.out.println(payList);
		}
		return fw;
	}

}
