package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/initServlet")
public class InitServlet extends HttpServlet{
	
	//서블릿 : 서버측에서 실행되는 웹페이지(자바코드)
	//		톰캣 컨테이너가 실행시켜줌.
	//		<-> 클라이언트의 요청이 있으면. url: locahost:8081/HelloWeb/initServlet
	// .java 확장자 -> ./class 파일 컴파일이 된 후 .class 파일이 실행.
	public InitServlet() {
		System.out.println("InitServlet() Call.");
	}
	
	//'init'작성 후 Ctrl+space 2번째
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() Call.");
	}
	
	//'service'작성 후 Ctrl+space 1번째
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() Call.");
		resp.setContentType("text/html;charset=UTF-8"); //화면의 출력되는 컨텐츠의 타입 지정.(한,일,중)
		// 사용자의 화면에 출력. -> 출력스트림 생성.(내용을 주고받는 것)
		PrintWriter out = resp.getWriter(); //출력스트림 생성.
		out.print("initServlet 페이지입니다"); //한글처리가 안되면 ???같은 형태로 나옴.
		out.print("<h3>InitPage</h3>");
		out.print("<a href='index.html'>index페이지로이동</a>");
	}
	
	
}
