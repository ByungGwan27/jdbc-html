<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- 태그 라이브러리 부르는 법(톰캣 제공) -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 사용X -->
 <table border="1">
  <thead><tr><th>글번호</th><th>제목</th><th>작성자</th></tr></thead>
  <c:forEach var="notice" items="${list }">
   <tr>
    <td>${notice.noticeId }</td> 
    <td>${notice.noticeTitle }</td> 
    <td>${notice.noticeWriter }</td> 
   </tr>
  </c:forEach>
 </table>
</body>
</html>