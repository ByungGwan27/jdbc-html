package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	
	// key & value 저장할 수 있는 컬렉션. Map
	Map<String, Control> map;
	
	public FrontController() {
		System.out.println("FrontController() call.");
		map = new HashMap<>();
	}
	
	//init Ctrl+space
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() call.");
		map.put("/main.do", new MainControl());
		map.put("/first.do", new FirstControl()); //first.do가 호출되면 '2번쨰(new InitServlet()())'안내 메세지 출력
		map.put("/second.do", new SecondControl());
		// 사원정보 상세페이지(getMember.jsp)
		map.put("getMember.do", new GetMemberControl());
		// 사원정보 수정페이지(modifyMember.jsp)
		map.put("/modifyMember.do", new ModifyMemberControl());
		// 사원정보등록화면.(addMemberForm.jsp)
		map.put("/addMemberForm.do", new AddMemberFormControl());
		// 사원정보DB등록.
		map.put("/addMember.do", new AddMemberControl());
		//사원정보 삭제.
		map.put("/deleteMember.do", new DeleteMemberControl());
		//로그인 화면 (아이디/이메일 입력화면)
		map.put("/loginForm.do", new LoginFormControl());
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8"); //요청정보에 한글이 있으면 utf-8로 지정
		resp.setContentType("text/html;charset=utf-8"); //응답정보가 html페이지면
		
		System.out.println("service() call.");
		// http://localhost:8081/HelloWeb/first.do
		String uri = req.getRequestURI(); //HelloWeb/first.do 호출. getRequestURI()는 URL값 중 호스트정보와 포스트값을 뺸 값
		String context = req.getContextPath(); //context: /HelloWeb -> 프로젝트 이름
		String page = uri.substring(context.length());
		
		System.out.println(page);
		System.out.println(map.get(page));
		
		Control control = map.get(page); //값을 Object로 받음
		control.exec(req, resp);
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() call.");
	}
	
	
	
	
}
