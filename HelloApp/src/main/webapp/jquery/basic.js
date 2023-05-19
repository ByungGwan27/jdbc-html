  //basic.js
  
  // document.addEventListener('DOMContentLoaded', function () {
    // let liTag = document.createElement('li'); // Document Object Model.
    // liTag.innerText = 'Cherry';
    // liTag.append();
    // console.log(liTag);
    // document.querySelector('#list').append(liTag);
    // })
    
    // javascript 객체 vs. jQuery객체
    // $(document).ready(function () {
    //   // let elem = jQuery('<li />');
    //   let elem = $('<li />');
    //   // elem.innerText : jQuery객체는 jQuery에서 제공해주는 메소드를 사용해야 하기에 에러 발생.
    //   elem.text('Cherry');
    //   console.log(elem);
    //   $('#list').append(elem);
    // })

    //메소드 체인이 가능함
    $(document).ready(function () {
      $('#list').append($('<li />').text('Cherry'),
                        $('<li />').text('Mango'));
    })