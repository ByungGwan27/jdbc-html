// fetchMember.js

// $(function() {
//   $('#list').remove();
//   $('#show2').remove();
//   $('#show').empty();
//   $('#show').before('<h3>회원목록</h3>');

//   // json 데이터 출력.
//   fetch('MOCK_DATA.json')
//   .then(function(rr) {
//     return rr.json(); // 출력 stream -> object타입으로 변경
//   })
//   .then(function(rrr) {
//     console.log(rrr);
//     let tbl = $('<table border="1" />');
//     let tbd = $('<tbody />').attr('id', 'memberList');
//     rrr.forEach(function(member) { //배열이라 forEach사용가능
//       let tr = $('<tr />').append( $('<td />').text(member.id),
//                                    $('<td />').text(member.first_name),
//                                    $('<td />').text(member.last_name),
//                                    $('<td />').text(member.gender),
//                                    // 버튼 작성
//                                   $('<td />').append(
//                                     $('<button>삭제</button>').on('click', delMember)
//                                     )
//                                  );
//       tbd.append(tr);
//     });
//     tbl.append(tbd);
//     $('#show').append(tbl); //<div id="show"><table border='1'>...</table></div>
//     makeHead();
//   })
//   .catch(function (err) {
//     console.error(err);
//   }) //end of fetch().

//   function makeHead() {
//     // title등록
//     $('table').prepend(
//     $('<thead />').append($('<th />').text('ID'),
//                           $('<th />').text('이름'),
//                           $('<th />').text('성씨'),
//                           $('<th />').text('성별'),
//                           $('<th />').text('삭제')
//                          )
//     );
//   }
//   // 한라인 삭제.
//   function delMember(eee) { //e는 이벤트
//     //console.log(eee.target.parent());//parent는 js객체라 사용 못함
//     $(eee.target).parentsUntil('tbody').remove();
//   }

// });

//1-2
$(function() {
  //기존 목록 제거
  $('#list').remove();
  $('#show2').remove();
  $('#show').empty();
  $('#show').before('<h3>회원목록</h3>');

  // json 데이터 출력.
  fetch('MOCK_DATA.json')
  .then(function(rr) {
    return rr.json(); // 출력 stream -> object타입으로 변경
  })
  .then(makeList)
  .catch(function (err) {
    console.error(err);
  }) //end of fetch().

  // '등록'버튼 이벤트 추가.
  // $('button:contains(등록)').on('click', addMemberFnc);
  $('button:eq(0)').on('click', addMemberFnc);

  // tr에 마우스 오버가 되면 등록화면에 출력이 되도록.
  $('body').on('mouseover', '#memberList tr', function () {
    
    let oldId = $(this).children().eq(0).text();
    let oldFname = $(this).children().eq(1).text();
    let oldLname = $(this).children().eq(2).text();
    let oldGender = $(this).children().eq(3).text();

    $('#id').val(oldId);
    $('#fname').val(oldFname);
    $('#lname').val(oldLname);
    $('#gender').val(oldGender);
  });

  // 라이브 이벤트.. 더블 클릭 시 수정창으로 만들기
  $('body').on('dblclick', '#memberList tr', function () {
    //console.log('tr click.');
    // 새로운 tr을 생성.
    let oldTr = $(this);
    let oldId = $(this).children().eq(0).text();
    let oldFname = $(this).children().eq(1).text();
    let oldname = $(this).children().eq(2).text();
    let oldGender = $(this).children().eq(3).text();
    
    let newTr = $('<tr />').append(
      $('<td />').text(oldId),
      $('<td />').append($('<input />').val(oldFname)),
      $('<td />').html('<input type="text" value="' + oldname + '">'),
      $('<td />').html('<input type="text" value="' + oldGender + '">'),
      $('<td />').append($('<button />').text('수정').on('click', updateTr)),
      $('<td />').html('<input type="checkbox">')
    );
    
    console.log(oldTr);
    oldTr.replaceWith(newTr);
  })

  //수정창 입력 된 값 변경하기
  function updateTr() {
    let oldTr = $(this).parentsUntil('tbody');
    console.log(oldTr);
    let id = oldTr.find('td:eq(0)').text();
    let fname = oldTr.find('td:eq(1)>input').val();
    let lname = oldTr.find('td:eq(2)>input').val();
    let gender = oldTr.find('td:eq(3)>input').val();
   
    let newTr = $('.template').clone();
    newTr.find('td:eq(0)').text(id);
    newTr.find('td:eq(1)').text(fname);
    newTr.find('td:eq(2)').text(lname);
    newTr.find('td:eq(3)').text(gender);
    newTr.find('td:eq(5)').html('<input type="checkbox">');
    //newTr.toggleClass('template');//기본클래스가 있으면 빼주고 없으면 추가
    newTr.removeClass('template');//다 빼고싶을 때 removeClass

    console.log(newTr);
    oldTr.replaceWith(newTr);
  }

  // 변경 클릭 시 상단 입력창 항목과 값이 바뀌기
  $('body').on('click', 'button:eq(1)', function () {
    //let newId = $('')
    console.log($(this));
    let newTr = $(this).parentsUntil('tbody');
    let newId = $('#id').val();
    let newFname = $('#fname').val();
    let newLname = $('#lname').val();
    let newGender = $('#gender').val();
    console.log(newLname);
    console.log('알려줘' , newTr);
    console.log('여기');
    console.log($('.template>td:eq(0)'));
    let oldTr = $('.template').clone();
    oldTr.find('td:eq(0)').text(newId);
    oldTr.find('td:eq(1)').text(newFname);
    oldTr.find('td:eq(2)').text(newLname);
    oldTr.find('td:eq(3)').text(newGender);
    oldTr.find('td:eq(5)').html('<input type="checkbox">');

    //newTr.replaceWith(oldTr);
  })

  //등록 버튼 누를 시 하단에 추가하기
  function addMemberFnc () {
    
    if(!$('#id').val() || !$('#fname').val() || !$('#lname').val()) {
      alert('필수값 입력.');
      return;
    }

    // 사용자 입력값을 체크. 목록의 제일 마지막 위치에 추가.
    let tr = $('<tr />').append(
                $('<td />').text($('#id').val()),
                $('<td />').text($('#fname').val()),
                $('<td />').text($('#lname').val()),
                $('<td />').text($('#gender').val()),
                // 버튼작성.
                $('<td />').append(
                  $('<button>삭제</button>').on('click', delMember)
                )
              );
    
    $('#memberList').append(tr); //목록에 추가.
    $('input[type="text"]').val('');
  }

  $('tr').on('dblclick', function () {
    console.log('tr click.티알티알');// 위의 입력창 클릭해야 됨
  })

  //리스트 생성
  function makeList (rrr) {
      console.log(rrr);
      let tbl = $('<table border="1" />');
      let tbd = $('<tbody />').attr('id', 'memberList');
      rrr.forEach(function(member, idxxx) { //배열이라 forEach사용가능
        if(idxxx < 5) {
          let tr = $('<tr />').append( $('<td />').text(member.id),
                                      $('<td />').text(member.first_name),
                                      $('<td />').text(member.last_name),
                                      $('<td />').text(member.gender),
                                      // 버튼 작성
                                      $('<td />').append(
                                        $('<button>삭제</button>').on('click', delMember)
                                        ),
                                      $('<td />').html('<input type="checkbox">')
                                    );
          tbd.append(tr);
        }
      });
      tbl.append(tbd);
      $('#show').append(tbl); //<div id="show"><table border='1'>...</table></div>
      makeHead();
  }

  //타이틀 생성
  function makeHead() {
    // title등록
    $('table:eq(1)').prepend(
    $('<thead />').append($('<th />').text('ID'),
                          $('<th />').text('이름'),
                          $('<th />').text('성씨'),
                          $('<th />').text('성별'),
                          $('<th />').text('삭제'),
                          $('<th />').html('<input type="checkbox">')
                         )
    );
  }

  // 삭제 버튼 누를 시 한 라인 삭제.
  function delMember(eee) { //e는 이벤트
    //console.log(eee.target.parent());//parent는 js객체라 사용 못함
    $(eee.target).parentsUntil('tbody').remove();
  }
  
})