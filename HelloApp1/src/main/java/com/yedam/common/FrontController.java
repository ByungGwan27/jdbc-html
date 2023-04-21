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

import com.yedam.notice.control.NoticeListControl;

public class FrontController extends HttpServlet {
	String encoding;
	private Map<String, Control> map;
	
	public FrontController() {
		map = new HashMap<>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		encoding = config.getInitParameter("enc");
		// 첫페이지.
		map.put("/main.do", new MainControl()); //url패턴과 Control객체
		
		// 공지사항.
		map.put("/noticeList.do", new NoticeListControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding(encoding);
		
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		
		Control control = map.get(path);
		String viewPage = control.execuet(req, resp); //이전에는 control 안에서 포워딩 처리를함
		System.out.println(viewPage);
		
//		//.tiles 처리 방법
//		if (viewPage.endsWith(".tiles")) {
//			
//		}
		
		// 페이지 재지정.
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
		
	}
	
}
