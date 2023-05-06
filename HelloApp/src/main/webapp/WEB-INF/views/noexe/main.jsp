<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>
<!-- 사용X -->
 <p>Main page</p>
 <p>Expression Language(=표현식)</p> 
 ${3>2}
 ${"Hello" }
 ${10 -5 }
 ${myName != null}
 ${myName != null ? '<p>있음</p>' : '<p>없음</p>' }
</body>
</html>