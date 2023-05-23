import {
    basket
} from './basket.js';

document.addEventListener('DOMContentLoaded', function () {

    basket.cartList();

    // 선택상품 삭제.
    document.querySelector('.basketrowcmd a:first-child').addEventListener('click', function () {
        basket.delCheckedItem();
    })

    // 장바구니 비우기.
    document.querySelector('.basketrowcmd a:nth-child(2)').addEventListener('click', function () {
        basket.delAllItem();
        
    })

    // 장바구니 삭제 클릭.
    document.querySelectorAll('.basketcmd a').forEach(function (item) {
        item.addEventListener('click', function () {
            basket.delItem();
            //$(this).parent().parent().parent().remove();
        })
    })

    // 수량변경 - 이벤트 종류 구분.
    document.querySelectorAll('.updown').forEach(function (item, idx) {
		
        item.querySelector('input').addEventListener('keyup', function () {
            //basket.changePNum(idx);
            let count = Number($(this).val());
            
            let price = Number($(this).parent().parent().prev().children().val());
            
            Number($(this).parent().parent().next().text((count) * price)).formatNumber();
            
            //console.log($('.sum').text());
            
            ttcc();
            
            ttpp();
        })
        item.children[1].addEventListener('click', function () {
            //basket.changePNum(idx);
            
            let count = Number($(this).parent().children().val());
            //console.log(count);
            $(this).parent().children().eq(0).attr('value',count + 1);
            $(this).parent().children().eq(0).val(count + 1);
            //console.log($(this).parent().children());
            
            let price = Number($(this).parent().parent().prev().children().val());
            //console.log(price);
            
            Number($(this).parent().parent().next().text((count+1) * price)).formatNumber();
            
            ttcc();
            
            ttpp();
            
        })
        item.children[2].addEventListener('click', function () {
            //basket.changePNum(idx);
            let count = Number($(this).parent().children().val());
            if(count > 1) {
            $(this).parent().children().val(count - 1);
            
            let price = Number($(this).parent().parent().prev().children().val());
            
            Number($(this).parent().parent().next().text((count-1) * price)).formatNumber();
            
            ttcc();
            
            ttpp();
            
            } else {
				alert('1이상만 가능');
			}
        })
        
        function ttcc() {
			let tc = 0;
			
			for(let i = 1; i <$('.p_num').length; i++) {
				tc += Number($('#p_num'+i).val());
			}
            console.log('tc : ' + tc);
            $('#sum_p_num').text('상품갯수: '+ tc + '개');
		}
		
		function ttpp() {
			let tp = 0;
			
			for(let i = 1; i <$('.p_num').length; i++) {
				tp += Number($('#basket>div:eq(' + (i+1) + ')>div:eq(1)>div:eq(2)').text().replace(/[^0-9]/g, ""));
			}
			console.log('tp : ' + tp);
			$('#sum_p_price').text('합계금액: '+ tp + '원');
		}
        
    })

    // anchor : 스크롤 탑 차단.
    document.querySelectorAll('a[href="#"]').forEach(function (item) {
        item.setAttribute('href', 'javascript:void(0)');
    })
})

// 숫자 3자리 콤마찍기
Number.formatNumber = function () {
    if (this == 0) return 0;
    let regex = /(^[+-]?\d+)(\d{3})/;
    let nstr = (this + '');
    while (regex.test(nstr)) nstr = nstr.replace(regex, '$1' + ',' + '$2');
    return nstr;
};