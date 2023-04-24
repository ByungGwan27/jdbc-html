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

import com.yedam.member.control.LoginControl;
import com.yedam.member.control.LoginFormControl;
import com.yedam.member.control.LogoutControl;
import com.yedam.member.control.modifyMember;
import com.yedam.member.control.modifyMemberControl;
import com.yedam.notice.control.AddNoticeControl;
import com.yedam.notice.control.AddReplyControl;
import com.yedam.notice.control.GetNoticeControl;
import com.yedam.notice.control.ModifyNoticeControl;
import com.yedam.notice.control.NoticeAddForm;
import com.yedam.notice.control.NoticeListControl;
import com.yedam.notice.control.RemoveReplyControl;
import com.yedam.notice.control.ReplyListControl;

public class FrontController extends HttpServlet {

	private Map<String, Control> map;
	String encoding;

	public FrontController() {
		map = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		//초기 실행
		encoding = config.getInitParameter("enc");
		// 첫페이지.
		map.put("/main.do", new MainControl());

		// 공지사항.
		map.put("/noticeList.do", new NoticeListControl());
		map.put("/noticeAddForm.do", new NoticeAddForm());
		map.put("/addNotice.do", new AddNoticeControl());
		map.put("/getNotice.do", new GetNoticeControl());
		map.put("/modifyNotice.do", new ModifyNoticeControl());
		
		// 회원관련
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());
		//정보수정화면 넘겨주기
		map.put("/modifyMemberInfo.do", new modifyMemberControl());
		//정보수정
		map.put("modifyMember.do", new modifyMember());
		
		// 댓글정보
		map.put("/replyList.do", new ReplyListControl());
		map.put("/addReply.do", new AddReplyControl()); //아작스가 호출
		map.put("/removeReply.do", new RemoveReplyControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//버튼을 누를 때 서비스가 실행됨
		req.setCharacterEncoding(encoding);

		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length()); //.do를 받아옴
		System.out.println(path);

		Control control = map.get(path/*uri*/); //인터페이스와 구현클래스 확인. 어떤 기능만구현할건지
		String viewPage = control.execute/*실행*/(req/*페이지 요청정보*/, resp);
		System.out.println(viewPage);

		if (viewPage.endsWith(".do")) {
			resp.sendRedirect(viewPage);//.do면 tiles가 실행이 안되서 다시찾기
			return;
		}
		
		//4.24
		if (viewPage.endsWith(".json")) {
			resp.setContentType("text/json;charset=UTF-8");
			resp.getWriter().print(viewPage.substring(0, viewPage.length() - 5));
			return;
		}

		// 페이지 재지정. tiles면 실행
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);

	}
}
