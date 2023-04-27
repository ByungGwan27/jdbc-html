package com.yedam.prod.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.prod.domain.ProductVO;
import com.yedam.prod.service.ProductService;
import com.yedam.prod.service.ProductServiceImpl;

public class ProdListControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prodCode = req.getParameter("prodCode");
		ProductService service = new ProductServiceImpl();
		ProductVO vo = service.ProductInfo(Integer.parseInt(prodCode));
		
		req.setAttribute("prodInfo", vo);
		System.out.println("누누누누"+vo);
		List<ProductVO> list = service.getProductAllInfo();
		req.setAttribute("prochu", list);
		System.out.println("구구구구"+list);
		
		
		return "prod/prodList.tiles";
	}

}
