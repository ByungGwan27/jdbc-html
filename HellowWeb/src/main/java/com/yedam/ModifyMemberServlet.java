package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

@WebServlet("/modifyMemberServlet") //form의 action의 값
public class ModifyMemberServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String eId = req.getParameter("emp_id");
		String fName = req.getParameter("first_name");
		String lName = req.getParameter("last_name");
		String email = req.getParameter("email");
		
		Employee emp = new Employee();
		
		emp.setEmployeeId(Integer.parseInt(eId));
		emp.setFirstName(fName);
		emp.setLastName(lName);
		emp.setEmail(email);
		
		EmpDAO dao = new EmpDAO();
		boolean result = dao.updateMember(emp);
		
		if(result) {
			resp.sendRedirect("empList");
		} else {
			resp.sendRedirect("modifyMember.jsp");
		}
	}
	
}
