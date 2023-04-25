package com.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.member.domain.MemberVO;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceImpl;

public class modifyMember implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService service = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		String email = req.getParameter("email");
		String password = req.getParameter("pass");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		
		vo.setEmail(email);
		vo.setPassword(password);
		vo.setPhone(phone);
		vo.setAddress(address);
		
		service.modifyMember(vo);
		
		
		
		return "noticeList.do";
	}

}
