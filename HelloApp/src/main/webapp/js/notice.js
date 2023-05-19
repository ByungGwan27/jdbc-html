// 5.19 12: 17
// multipart request.

function deleteRow() {
	// ajax 호출. id를 기준으로 삭제 후 화면에서 제거.
	let tr = $(this/*tr의*/).closest/*가까운 걸 선택*/('tr');
	let id = tr.children().eq(0).text();
	
	$.ajax({
		url: 'delNoticeJson.do?nid=' + id,
		dataType:'html', // Success, Fail
		error: function (xhr) {
			console.log(xhr);
		},
		success: function (result) {
			if (result == 'Success') {
				console.log(tr);
				tr.remove();		
			} else if (result == 'Fail') {
				alert('처리 에러.');
			} else {
				alert('알 수 없는 반환.');
			}
		}
	})
	.always(function () {
		console.log('final.')
	})
	
}

$(document).ready(function() {
	$('form').on('submit', function(e) {
		e.preventDefault(); // form.submit 기능 차단.
		var frm = $('form')[0];
		//밑에 인풋타입 value값을 바꿔 서블렛에서 다른 요청을 하기 위해
		$(frm).find('input[name="job"]').val('multi'/*임의로 값을 넣음(ajax만 아니면 됨)*/);
		var data = new FormData(frm/* 매개값으로 멀티파트 요청*/); //multipart/form-data 처리하는 객체.
		for (let val of data.entries()) {
			console.log(val);
		}
		$.ajax({
			url: 'addNotice.do',
			method: 'post',
			data: data,
			// multipart요청.
			contentType: false,
			processData: false,
			error: function(jqxhr) {
				console.log(jqxhr.responseText);
			},
			success: function(data, status, xhr) {
				$('form').after($('<p />').text("작성자:" + data.retVal.noticeWriter
					+ "제목: " + data.retVal.noticeTitle
					+ "파일" + data.retVal.attachFile));
			}
		})
			.always(function() {
				console.log('final.');
			})
	}); //end of 등록 버튼.
	// 공지 목록 출력.
	$.ajax({
		url: 'noticeListJson.do',
		method: 'GET',
		dataType: 'json',
		error: function(xhr) {
			console.log(xhr.responseText);
		},
		success: function(data) {
			console.log(data);
			data.forEach((notice) => {
				let tr = $('<tr />').append( $('<td />').text(notice.noticeId),
											 $('<td />').text(notice.noticeTitle),
											 $('<td />').text(notice.noticeWriter),
											 $('<td />').append(
												 $('<img />').css('width', '50px').attr('src', 'images/' + notice.attachFile)),
											 $('<td />').append($('<button />').text('삭제').on('click', deleteRow))
											 					
				)
				$('#noticeList').append(tr);
				
			})
		}
	})
});