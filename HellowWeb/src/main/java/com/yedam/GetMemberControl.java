package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class GetMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		// 매개값으로 사원번호.
		// 요청 정보 처리
		String empId = req.getParameter("emp_id"); //emp_id를 받아옴
		EmpDAO dao = new EmpDAO();
		Employee emp = dao.getEmp(Integer.parseInt(empId));
		
		req.setAttribute("empInfo", emp);
		// 페이지 재지정. control -> getMember.jsp
		try {
			req/*요청정보*/.getRequestDispatcher("WEB-INF/views/getMember.jsp"/*이동할 페이지*/).forward(req, resp/*실제 이동할 페이지*/);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}; 
	}

}
