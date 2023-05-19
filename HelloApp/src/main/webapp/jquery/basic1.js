// basic2.js

$(document).ready(function () {
  console.log($('ul>li:nth-of-type(1)')) //li태그 중에서 첫번쨰 요소만 가져옴

  $('ul>li:nth-of-type(1)').css('background', 'yellow');
  $('ul>li:nth-of-type(2)').css('color', 'red');

  //$('#show button')[0] //뒤에 배열표시로 사용가능?
  $('#show>p>button:eq(0)').css('background', 'orange');
  //console.log($('span:eq(1)'));
  //$('span:eq(1)').text('월드'); // 글자 바꾸기
  $('span:eq(1)').html('<b>월드<b/>'); // html태그를 쓰면 태그로 변경됨
  
  //div가 다른 두개의 Hello의 색 바꾸기
  $('div>p:nth-of-type(1)>span').css('color', 'red');

  $('div#show>p:gt(0)>span').css('background', 'red');

  $('#show2>p:not(:eq(1))>span').css('background', 'purple');

  $('span:contains(Good)').css('fontSize', '20px');

  $('p:has(b)').css('background', 'green');
});