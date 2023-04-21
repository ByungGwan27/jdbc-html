package com.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//어트리뷰트에 myName라는 변수에 값 넣어주는걸 
		//FrontController에서 jsp에서 받을수있게 해줌
		req.setAttribute("myName", "Hongkildong"); 
		return "product/productList.tiles";
	}

}
