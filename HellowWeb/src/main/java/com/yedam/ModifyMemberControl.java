package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class ModifyMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		// View에서 요청한 method을 구분. GET/POST방식인지 확인
		// GET 방식이면 기존 코드 활용
		if (req.getMethod().equals("GET")) {

			// emp_id 파라미터.
			// MVC 패턴. 컨트롤에서 DB의 처리.View화면으로 정보를 전송.
			// emp 변수에 조회결과를 담아서 empInfo의 속성으로 modifyMember.jsp 재지정.

			String empId = req.getParameter("emp_id"); // emp_id를 받아옴
			EmpDAO dao = new EmpDAO();
			Employee emp = dao.getEmp(Integer.parseInt(empId));

			req.setAttribute("empInfo", emp);

			try {
				req/* 요청정보 */.getRequestDispatcher("WEB-INF/views/modifyMember.jsp"/* 이동할 페이지 */).forward(req,
						resp/* 실제 이동할 페이지 */);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} else if (req.getMethod().equals("POST")) {
			// DB 업데이트 처리를 하고 목록을 이동.
			String empId = req.getParameter("emp_id"); 
			String lname = req.getParameter("first_name"/*modifyMember의 name값*/);
			String fname = req.getParameter("last_name");
			String email = req.getParameter("email");
			
			Employee emp = new Employee();
			emp.setEmployeeId(Integer.parseInt(empId));
			emp.setFirstName(fname);
			emp.setLastName(lname);
			emp.setEmail(email);
			
			EmpDAO dao = new EmpDAO();
			boolean result = dao.updateMember(emp);
			try {
				if(result) {
					resp.sendRedirect("main.do");
				} else {
					resp.sendRedirect("modifyMember.do");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}
}
