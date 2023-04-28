package com.yedam.FrontControl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.prod.control.ProdListControl;
import com.yedam.prod.control.ProdMainControl;
import com.yedam.prod.control.ProductAddControl;
import com.yedam.prod.control.ProductUploadControl;

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
		
		// 메인페이지.
		map.put("/prodMain.do", new ProdMainControl());
		
		// ckedior 관련.
		map.put("/productAdd.do", new ProductAddControl());
		map.put("/prodUpload.do", new ProductUploadControl());
		
		map.put("/prodList.do", new ProdListControl());

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
