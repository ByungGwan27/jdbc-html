<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>공지사항등록 페이지입니다.</h3>

<form action="addNotice.do" method="post" enctype="multipart/form-data">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><input type="text" name="nid" value="${noticeInfo.noticeId }" readonly></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${noticeInfo.noticeTitle }" readonly></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="3" cols="20" name="subject">${noticeInfo.noticeSubject }</textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer">${noticeInfo.noticeWriter }</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td><img width="200px" src="images/${noticeInfo.attachFile }"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit">수정</button>
				<button type="reset">삭제</button>
			</td>
		</tr>
	</table>
</form>