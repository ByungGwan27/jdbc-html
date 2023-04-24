<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>공지사항상세 페이지.(noticeGet.sjp)</h3>

<style>
 #content {
 padding: 15px auto;
 }
</style>

<form action="modifyNotice.do" method="GET">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><input type="text" name="nid"
				value="${noticeInfo.noticeId }" readonly></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"
				value="${noticeInfo.noticeTitle }" readonly></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea readonly rows="3" cols="20" name="subject">${noticeInfo.noticeSubject }</textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer"
				value="${noticeInfo.noticeWriter }" readonly></td>
		</tr>
		<tr>
			<th>첨부파일: ${fileType }</th>
			<td><c:if test="${noticeInfo.attachFile != null }">
					<c:choose>
						<c:when test="${fileType == 'image' }">
							<img width="200px" src="images/${noticeInfo.attachFile }">
						</c:when>
						<c:otherwise>
							<a href="images/${noticeInfo.attachFile }">${noticeInfo.attachFile }</a>
						</c:otherwise>
					</c:choose>
				</c:if></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><c:choose>
					<c:when test="${noticeInfo.noticeWriter == id }">
						<button type="submit">수정</button>
					</c:when>
					<c:otherwise>
						<button type="submit" disabled="disabled">수정</button>
					</c:otherwise>
				</c:choose> <!-- <button type="button" onclick="location.href='noticeList.do'">목록</button> -->
				<button type="button"
					onclick="location.href='noticeList.do?page=${pageNum}'">목록</button>
			</td>
		</tr>
	</table>
</form>

<!-- 4.24댓글등록 -->
<div id="content">
 <input type="text" id="reply">
 <span>${id }</span>
 <button type="button" id="addBtn">등록</button>
</div>

<table class="table">
 <thead>
  <tr>
   <th>댓글번호</th><th>글내용</th><th>작성자</th><th>삭제</th>
  </tr>
 </thead>
 <tbody id="tlist">
 </tbody>
</table>


<!-- 4.24 댓글정보. -->
<script>
 let showFields = ['replyId', 'reply', 'replyWriter']
 let xhtp = new XMLHttpRequest(); //Ajax호출.
 xhtp.open('get', 'replyList.do?nid=${noticeInfo.noticeId}');
 xhtp.send();
 xhtp.onload = function () {
	 console.log(xhtp.response);
	 let tlist = document.querySelector('#tlist');
	 //목록생성.
	 let data = JSON.parse(xhtp.response);
	 
	 for(let reply of data) {
		 console.log(reply);
		 let tr = makeTrFunc(reply);
		 /* let tr = document.createElement('tr');
		 for(let prop of showFields) {
		 	let td = document.createElement('td');
		 	td.innerText = reply[prop];
		 	tr.append(td);
		 } */
	 tlist.append(tr);
	 }
 }
 
 //tr 생성해주는 함수.
 function makeTrFunc(reply = {}) {
	 let tr = document.createElement('tr');
	 for (let prop of showFields) {
	 	let td = document.createElement('td');
	 	td.innerText = reply[prop];
	 	tr.append(td);
	 }
   // 삭제버튼.
   let btn = document.createElement('button');
	 btn.addEventListener('click', function (e) {
		let did = btn.parentElement.parentElement.children[0].innerText;
		// db에서 삭제 후... 화면에서 삭제.
		let xhtp = new XMLHttpRequest();
		xhtp.open('post', 'removeReply.do');
		xhtp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhtp.send('rid=${did }');

		xhtp.onload = function () {
			let result = xhtp.response;
			if(result.retCode == 'Success') {
				// 화면에서 지우기.
				 let tr = makeTrFunc(result.data);
				 tlist.append(tr);
			} else if (result.retCode == 'Fail') {
				alert('처리중 에러발생.');
			} else {
				alert('알수 없는 결과값입니다.')
			}
		}

	 })
  	 btn.innerText = '삭제'
	 let td = document.createElement('td');
	 td.append(btn);
	 tr.append(td);
	 return tr; //생성한 tr을 반환
	 }
 
  // 등록이벤트...
  document.querySelector("#addBtn").addEventListener('click', addReplyFnc);
  function addReplyFnc(e) {
	  // 로그인 여부를 체크해서 로그인 정보가 없으면 로그인 화면으로 이동하기
	  let id = document.querySelector('#content span').innerText;
	  if (id == null || id == '') {
		  alert("로그인 후에 처리하세요.");
		  location.href = 'loginForm.do';
		  return;
	  }
	  
	  console.log('click', e.target);
	  console.log('reply', document.querySelector("#reply").value)
	  console.log('id', "${id }");
	  let reply = document.querySelector("#reply").value;
	  
	  // Ajax 호출.
	  let xhtp = new XMLHttpRequest();
	  xhtp.open('post', 'addReply.do');
	  xhtp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); //post방식은 해당 구문을 추가
	  xhtp.send('id=${id }&reply=' + reply + "&notice_id=${noticeInfo.noticeId}");
	  xhtp.onload = function () {
		  console.log(xhtp.response); //
		  let result = JSON.parse(xhtp.response);
		  if (result.retCode == 'Success') {
			  // 값을 활용해서 tr 생성.
			  let tr = makeTrFunc(result.data);
			  tlist.append(tr);
			  
			  // 입력값 초기화하기.
			  document.getElementById("reply").value = '';
			  document.getElementById("reply").focus(); //깜빡깜빡하는 기능
			  
		  } else if (result.retCode == 'Fail') {
			   alert("처리중 에러.")
		  }
	  }
  }
</script>
