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

@WebServlet("addMemberServlet")
public class AddMemberServlet extends HttpServlet{
	// 생성자, init, service
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String fname = req.getParameter("fname"); // input name="fname"
		String lname = req.getParameter("lname"); // getParameter는 addForm에서 설정한 name의 이름
		String email = req.getParameter("email");
		String job = req.getParameter("job");
		String hdate = req.getParameter("hdate");
		
		Employee emp = new Employee();
		emp.setFirstName(fname);
		emp.setLastName(lname);
		emp.setEmail(email);
		emp.setJobId(job);
		emp.setHiredate(hdate);
		
		EmpDAO dao = new EmpDAO();
		boolean result = dao.insertEmployee(emp);
		
		if(result) {
			resp.sendRedirect("empList");
		} else {
			resp.sendRedirect("employee/addForm.html");
		}
		
	}
}
