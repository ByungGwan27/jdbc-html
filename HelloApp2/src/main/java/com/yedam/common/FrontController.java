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
import com.yedam.notice.control.GetNoticeControl;
import com.yedam.notice.control.NoticeAddForm;
import com.yedam.notice.control.NoticeListControl;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;

public class FrontController extends HttpServlet {
	String encoding;
	private Map<String, Control> map;
	
	public FrontController() {
		map = new HashMap<>();
	}
	//환경파일 정보 넘겨주려면 읽어올때 ServletConfig 객체가
	//가지고있는 정보중에getinitParameter로 값받음
	@Override
	public void init(ServletConfig config) throws ServletException {
		encoding = config.getInitParameter("enc");
		
		// 첫페이지.
		map.put("/main.do", new MainControl()); //url패턴과 Control객체
		
		//공지사항>
		map.put("/noticeList.do", new NoticeListControl());
		//공지사항 등록page여는거
		map.put("/noticeAddForm.do", new NoticeAddForm());
		//기능
		map.put("/addNotice.do", new AddNoticeControl());
		map.put("/getNotice.do", new GetNoticeControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding(encoding);
		
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		System.out.println(path);
		
		//페이지 정보 받는곳
		Control control = map.get(path);
		String viewPage = control.execuet(req, resp); //이전에는 control 안에서 포워딩 처리를함
		System.out.println(viewPage);
		
		//.do 처리 방법
		if (viewPage.endsWith(".do")) { //끝에 .do가 넘어오면 재실행
			resp.sendRedirect(viewPage); //.tilse가 오면 재실행 안함
			return; //메소드의 종료
		}
		
		// 페이지 재지정. 페이지 정보 받아서 forwarding하는곳
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
		
	}
	
}
