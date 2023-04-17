package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

@WebServlet("/empList")
public class EmpListServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
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
	
	
	//등록 : 사용자의 입력(addForm.html)
	//처리 : 서블릿(insert기능: addMemberServlet)
	//결과: 목록페이지출력.
	//http://localhost:8081/HelloWeb/addMemberservlet?fname=kildong&lname=Hong
	
	//삭제: 사용자의 입력(delForm.html)
	//처리: 서블릿(delete기능: delMemberServlet)
	//결과: 목록페이지출력.
	//http://localhost:8081/HelloWeb/delMemberServlet?emp_id=215
	
	//조회: 사용자의 입력(searchForm.html)
	//처리: 서블릿(select기능: searchMember)
	//결과: 처리결과(사원번호 처리결과: 화면출력)
	
	
	//DBConnection기능: DAO.java
	//getConnection() => Connection 객체반환.
	
	//CRUD처리: EmpDAO.java
	
	//1.boolean insertEmp(Emlployee/*매개값(변수)*/)
	//2.Employee getEmp(int)
	//3.boolean deleteEmp(int)
	//4.List<Employee> getEmpList()
	
	//서블릿: 목록, 입력, 삭제....
	//addMemberServlet
	//delMemberServlet
	//empList
	
	
//	public static void main(String[] args) {
//		
//	}
}
