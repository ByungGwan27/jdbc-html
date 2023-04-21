package com.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.member.domain.MemberVO;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceImpl;

public class LoginControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// MemberSerivce/ MemberServiceImpl, MemberMapper.java
		// service: MemberVO loginCheck(MemberVO vo)
		// mapper: MemberVO loginCheck(MemberVO vo)
		String email = req.getParameter("email"); // loginForm.jsp의 name 참고
		String pwd = req.getParameter("pass");
		
		// id, pw 입력받기
		MemberVO vo = new MemberVO();
		vo.setEmail(email);
		vo.setPassword(pwd);
		
		MemberService service = new MemberServiceImpl();
		vo = service.loginCheck(vo);
		
		if(vo != null) { //성공.
			
			// 세션에 로그인 정보 지정.
			HttpSession session = req.getSession();
			session.setAttribute("id", vo.getEmail());
			session.setAttribute("name", vo.getName());
			
			return "noticeList.do";
		} else {
			return "member/loginForm.tiles";
		}
		
	}

}
