<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset='utf-8' />
  <!-- 해당 파일 위치를 맞춰야함 -->
  <script src='/fullcal/dist/index.global.js'></script>
  <script>
    document.addEventListener('DOMContentLoaded' /*DOM페이지가 다 다운로드 되면*/ , function () {
        var calendarEl = document.getElementById('calendar');

        // allEvents 초기화.
        let allEvents = [];

        //서버의 json 데이터를 가져오기 위한 fetch.
        fetch('eventList.do')
          .then(function (resolve) {
            return resolve.json();
          }) //{"title":"test", "startDate":"2023-04-05"}
          .then(function (result) {
            console.log(result); // result 는 [{...}, {...}, {...}] 배열 형태

            result.forEach(function (event) {
              let newEvent = {
                title: event.title,
                start: event.startDate,
                end: event.endDate
              }
              allEvents.push(newEvent);
            }); // end of forEach

            //시작...
            var calendar = new FullCalendar.Calendar(calendarEl, {
              headerToolbar: {
                left: 'prev,next today',
                center: 'title',
                right: 'dayGridMonth,timeGridWeek,timeGridDay'
              },
              initialDate: new Date(), //오늘날짜 넣기
              navLinks: true, // can click day/week names to navigate views
              selectable: true,
              selectMirror: true,
              select: function (arg) {
                var title = prompt('이벤트 등록 : ');
                if (title) {
                  // console.log(title, arg.startStr, arg.endStr);
                  // Ajax호출
                  fetch('addEvent.do', {
                      method: "POST",
                      headers: {
                        "Content-Type": 'application/x-www-form-urlencoded',
                      },
                      body: 'title=val&start_date=val&end_date=val' //d안의 start_date같은건 임의 파라미터값
                    })
                    .then(resolve => resolve.json())
                    .then(result => {
                      if (result.retCode == 'Success') {
                        // 화면에 추가된 이벤트등록.
                        calendar.addEvent({
                          title: title,
                          start: arg.start,
                          end: arg.end,
                          allDay: arg.allDay
                        })
                      } else {
                        alert('실패!');
                      }
                    })
                    .catch(err => console.log(err));
                  //end of fetch..
                }
                calendar.unselect()
              },
              eventClick: function (arg) {
                if (confirm('이벤트를 삭제하시겠습니까?')) {
                  // Ajax호출.
                  
                  arg.event.remove()
                }
              },
              editable: true,
              dayMaxEvents: true, // allow "more" link when too many events
              events: allEvents
            });
            calendar.render(); //캘린더를 열어줌
            // end..
          });
      }) // end of then
      .catch(function (err) {
        console.log(err);
      }); // end of addEventListener.
  </script>
  <style>
    body {
      margin: 40px 10px;
      padding: 0;
      font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
      font-size: 14px;
    }

    #calendar {
      max-width: 1100px;
      margin: 0 auto;
    }
  </style>
</head>

<body>
  <!-- full캘린더가 열릴 위치  -->
  <div id='calendar'></div>

</body>

</html>