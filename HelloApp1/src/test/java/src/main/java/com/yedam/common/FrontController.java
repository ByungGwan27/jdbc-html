package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.notice.control.AddNoticeControl;
import com.yedam.notice.control.NoticeAddForm;
import com.yedam.notice.control.NoticeListControl;

public class FrontController extends HttpServlet{
	private Map<String, Control> map;
	String encoding;
	public FrontController() {
		map = new HashMap<>();
	}
	//환경파일 정보 넘겨주려면 읽어올때 ServletConfig 객체가
	//가지고있는 정보중에getinitParameter로 값받음
	@Override
	public void init(ServletConfig config) throws ServletException {
		encoding = config.getInitParameter("enc");
		
		//첫페이지.
		map.put("/main.do", new MainControl());
		
		//공지사항>
		map.put("/noticeList.do", new NoticeListControl());
		//공지사항 등록page여는거
		map.put("/noticeAddForm.do", new NoticeAddForm());
		//기능
		map.put("/addNotice.do", new AddNoticeControl());
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		System.out.println(path);
		
		//페이지정보 받는곳
		Control control = map.get(path);
		String viewPage = control.execute(req, resp);
		System.out.println(viewPage);
		
//		if(viewPage.endsWith(".tiles")) {
//			
//		}
		
		//페이지정보를 받아서  forwarding하는곳(재지정하는곳)
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
		
	}
}
