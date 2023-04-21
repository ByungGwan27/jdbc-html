<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 태그 라이브러리 부르는 법(톰캣 제공) -->
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>noticeList</title>
</head>

<body>
    <table class="table">
        <thead>
            <tr>
                <th>글번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>조회수</th>
            </tr>
        </thead>
        <c:forEach var="notice" items="${list }">
            <tr>
            	<!-- nid는 파라미터 이름 -->
                <td><a href="getNotice.do?nid=${notice.noticeId }">${notice.noticeId }</a></td>
                <td>${notice.noticeTitle }</td>
                <td>${notice.noticeWriter }</td>
                <td>${notice.hitCount }</td>
            </tr>
        </c:forEach>
    </table>
</body>

</html>