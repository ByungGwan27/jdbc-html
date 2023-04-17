package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

@WebServlet("searchMember")
public class GetMemberServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String viewId = req.getParameter("view");
		PrintWriter out = resp.getWriter();
		
		EmpDAO dao = new EmpDAO();
		Employee result = dao.getEmp(Integer.parseInt(viewId));
		
		if(result != null) {
			out.print("<table border='1'>");
			out.print("<tr>");
			out.print("<th>사원번호</th>");
			out.print("<td>" + result.getEmployeeId() + "</td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<th>이름</th>");
			out.print("<td>" + result.getFirstName() + ", " + result.getLastName() + "</td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<th>이메일</th>");
			out.print("<td>" + result.getEmail() + "</td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<th>직업</th>");
			out.print("<td>" + result.getJobId() + "</td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<th>입사일</th>");
			out.print("<td>" + result.getHiredate() + "</td>");
			out.print("</tr>");
			out.print("</table>");
		} else {
			resp.sendRedirect("employee/SearchForm.html");
		}
	}
}
