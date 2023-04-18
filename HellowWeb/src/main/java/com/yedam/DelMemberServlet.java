package com.yedam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

@WebServlet("/delMemberServlet")
public class DelMemberServlet extends HttpServlet{
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String delId = req.getParameter("eid");
//		emp.setEmployeeId(delId);
		EmpDAO dao = new EmpDAO();
		boolean result = dao.deleteEmployee(Integer.parseInt(delId));
		
		if(result) {
			resp.sendRedirect("empList");
		} else {
			resp.sendRedirect("employee/delForm.html");
		}
	}
	
}
