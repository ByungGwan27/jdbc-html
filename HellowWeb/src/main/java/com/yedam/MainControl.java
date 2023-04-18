package com.yedam;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class MainControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			// 페이지 재지정.
			// resp.sendRedirect(); 내, 외부에있는 페이지에 가능. 파라미터값을 넘길 수 없음.
			EmpDAO dao = new EmpDAO();
			List<Employee> list = dao.getEmpList();
			
			req.setAttribute("listInfo", list);
			
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/empList.jsp")/*.forward(req, resp)*/; // WEB-INF밑에 views 밑에 empList.jsp 페이지를 재 지정하겠다
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
