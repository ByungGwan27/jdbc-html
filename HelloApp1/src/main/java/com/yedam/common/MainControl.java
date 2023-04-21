package com.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainControl implements Control {

	@Override
	public String execuet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("myName", "Hongkildong"); //forward는 frontController에서
//		return "WEB-INF/views/main.jsp";
		return "main.tiles"; //tilse의 레이아웃을 실행시키기 위해
	}

}
