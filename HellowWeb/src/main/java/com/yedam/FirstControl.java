package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class FirstControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		System.out.println("firstcontrol 실행.");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpList();
		
			out.print("<table border='1'>");
			out.print("<thead><tr><th>사원번호</th><th>FirstName</th><th>lname</th><th>email</th><th>직업</th><th>입사일</th></tr></thead>");
			out.print("<tbody>");
			for(Employee emp : list) {
				// 사원번호, fname, lname, email, phone...
				out.println("<tr><td><a href = 'searchMember?view=" + emp.getEmployeeId() +"'>" + emp.getEmployeeId());
				out.println("</a></td><td>" + emp.getFirstName() + "</td>");
				out.println("<td>" + emp.getLastName() + "</td>");
				out.println("<td>" + emp.getEmail() + "</td>");
				out.println("<td>" + emp.getJobId() + "</td>");
				out.println("<td>" + emp.getHiredate() + "</td></tr>");
//				out.println("<td>" + emp.getPhoneNumber()+ "</td></tr>");
			}
			out.print("</tbody>");
			out.print("</table>");
	}

}
