//5.19 12시 이전 내용
// $.ajax() 사용.
	$(document).ready(function () {		// 페이지가 다 로딩된 다음 호출
		$('form').on('submit', function(e) {
			e.preventDefault();		// 전송차단.??
			
			$.ajax({	//post방식
				url: 'addNotice.do',
				data: $(this).serialize(), // id=12&name=hong&age=20
				method: 'post',
				//dataType: 'html',
				dataType: 'json',//json타입으로 알아서 변환시켜줌
				error: function(jqxhr, textStatus, error) {
					console.log(jqxhr, textStatus, error);
				},
				success: function (data, textStatus, jqXHR ) {
					console.log(data, textStatus, jqXHR);
					
					let ul = $('<ul />').append(
										 $('<li />').text('작성자:' + data.retVal.noticeWriter),
									   $('<li />').text('제목:' + data.retVal.noticeTitle),
									   $('<li />').text('내용:' + data.retVal.noticeSubject)
					)
					$('form').after(ul);
				}
			})
			// .done(function (result) {
			// 	console.log(result);
			// }) 위에 error, success와 같은 옵션이 있어서 제외
			// .fail(function (err) {
			// 	console.log(err);
			// })
			.always(function () {
				console.log('final.');
			})
		})
	});