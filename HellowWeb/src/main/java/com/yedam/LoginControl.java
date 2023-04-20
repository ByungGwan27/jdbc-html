package com.yedam;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		// 사원번호(100), 이메일(SKING)
		String empId = req.getParameter("uname"); //loginForm.jsp 147번줄의 name
		String email = req.getParameter("psw");

		Employee emp = new Employee();
		emp.setEmployeeId(Integer.parseInt(empId));
		emp.setEmail(email);
		System.out.println("1: " + emp); // id, pw만

		EmpDAO dao = new EmpDAO();
		emp = dao.loginCheck(emp);
		System.out.println("2: " + emp); // loginCheck한 정보들
		
		try {
			if (emp == null) {
				resp.sendRedirect("loginForm.do");
			} else {
				// request객체/ session객체
				req.setAttribute("reqInfo", emp.getFirstName());
				
				HttpSession session = req.getSession();
				session.setAttribute("sesInfo", emp.getLastName());
				
				resp.sendRedirect("main.do"); // 이 문장만으론 Attribue의 값이 다음페이지로 이동못함.
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
