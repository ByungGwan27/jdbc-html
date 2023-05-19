<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script src='/js/notice.js'></script>
<h3>공지사항등록 페이지.</h3>
<!-- multipart/form-data는 파일 업로드 할 때 사용되는 인코딩 방식 -->

<form action="addNotice.do" method="post" enctype="multipart/form-data">
	<!-- 5.19 12시 이전 -->
	<!-- <input type="hidden" name="job" value="ajax"> -->
	<!-- 5.19 12:34 -->
	<input type="hidden" name="job" value="multi">
  <table class="table">
    <tr>
      <th>제목</th>
      <td><input type="text" name="title"></td>
    </tr>
    <tr>
      <th>내용</th>
      <td><textarea rows="3" cols="20" name="subject"></textarea></td>
    </tr>
    <tr>
      <th>작성자</th>
      <td><input type="text" name="writer" readonly value="${id }"></td>
    </tr>
    <tr>
      <th>첨부파일</th>
      <td><input type="file" name="attach"></td>
    </tr>
    <tr>
      <td colspan="2" allign="center">
        <button type="submit">등록</button>
        <button type="reset">취소</button>
      </td>
    </tr>
  </table>
</form>
<hr>
<div id="list">
	<table class="table">
		<thead>
			<tr>
				<th>글번호</th><th>제목</th><th>작성자</th><th>첨부파일</th>
			</tr>
		</thead>
		<tbody id="noticeList">

		</tbody>
	</table>
</div>