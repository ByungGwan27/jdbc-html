<%@page import="com.yedam.domain.Employee"%>
<%@page import="com.yedam.persistence.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="menu.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>
	<%
		Employee emp = (Employee) request.getAttribute("empInfo"); //GetMemberContorl의 setAttribute의 변수명과 맞춰주기
	/*EmpDAO dao = new EmpDAO();
	Employee result = dao.getEmp(Integer.parseInt(empId));
	*/
	%>
	
	<table border="1">
		<tr>
			<th>사원번호</th>
			<td><%=emp.getEmployeeId() %></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=emp.getFirstName() %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%=emp.getEmail() %></td>
		</tr>
			
	</table>
<jsp:include page="footer.jsp"></jsp:include>
