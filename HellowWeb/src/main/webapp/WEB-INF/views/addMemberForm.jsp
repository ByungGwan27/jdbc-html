<%@page import="com.yedam.domain.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="menu.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>

<!--  <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addMemberForm.jsp</title>
</head>
<body>
	<%
	Employee result = (Employee) request.getAttribute("empInfo");
	String lname = (String) session.getAttribute("sesInfo"); //loginControl 37번줄
  %>
-->
<p>Session: <%=lname %></p>
	<form action="addMember.do" method="post">
		firstName: <input type="text" name="fname"><br> <!--  parameter의 이름: -->
		lastName: <input type="text" name="lname"><br>
		email: <input type="text" name="email"><br>
		job: <input type="text" name="job"><br>
		hire: <input type="text" name="hdate"><br>
		<input type="submit" value="저장">
	</form>
<jsp:include page="footer.jsp"></jsp:include>
<!--  </body>
</html>-->