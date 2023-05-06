package com.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("myName", "Hongkildong"); //forward는 frontController에서
		
		//어트리뷰트에 myName라는 변수에 값 넣어주는걸 
		//FrontController에서 jsp에서 받을수있게 해줌
		
//		return "WEB-INF/views/main.jsp";
//		return "main.tiles"; //tilse의 레이아웃을 실행시키기 위해
		return "product/productList.tiles";
	}

}
