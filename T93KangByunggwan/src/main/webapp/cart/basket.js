export let basket = {
    totalCount: 0,
    totalPrice: 0,
    delCheckedItem: function () {
        console.log('delCheckedItem');
        let check = $('input:checkbox[name=buy]:checked');
        let cD = check.parent().parent().parent();
        cD.remove();
    },
    delAllItem: function () {
        console.log('delAllItem');
        $('.data').remove();
    },
    reCalc: function () {
        console.log('reCalc');
        this.totalCount = 0;
        this.totalPrice = 0;
    },
    updateUI: function () {
        console.log('updateUI');
        document.querySelector('#sum_p_num').textContent = '상품개수: ' + this.totalCount.formatNumber() + '개'
        document.querySelector('#sum_p_price').textContent = '합계금액: ' + this.totalPrice.formatNumber() + '원'
    },
    changePNum: function (pos) {
		let target = document.querySelector('div.row.data:nth-of-type('+pos+')');
		
        console.log("changePNum");
        console.log(event);
        
        if (event.target.tagName == 'INPUT') {
			console.log('input 클릭.');
		} else if (event.target.tagName == 'I'){
			
			//console.log(event.target.classList)
			if (event.target.classList.contains('up')) {
				console.log('icon 클릭. up');
				target.querySelector('input').value = 50;
			} else {
				console.log('icon 클릭. down');
				target.querySelector('input').value = -50;
			}
		}
    },
    delItem: function () {
        console.log('delItem');
        console.log(event.target.closest('div.row.data').remove());
    },
    cartList: function () {
        cartItems.forEach((item, idx) => {
            let template = document.querySelector('#template>div.row.data').cloneNode(true);
            template.querySelector('.img>img').setAttribute('src', '../img/' + item.image)
            template.querySelector('.pname>span').textContent = item.productNm
            template.querySelector('.basketprice>input').value = item.price
            template.querySelector('.basketprice').childNodes[2].textContent = item.price.formatNumber() + "원"
            template.querySelector('.updown>input').value = item.qty
            template.querySelector('.updown>input').setAttribute('value', item.qty)
            template.querySelector('.updown>input').setAttribute('id', 'p_num' + (idx + 1));
            template.querySelector('.sum').textContent = (item.price * item.qty).formatNumber() + "원"

            document.querySelector('#basket').append(template)
        })
    }
};

var cartItems = [{
        no: 1,
        productNm: '이것이 민트다.',
        qty: 2,
        price: 12000,
        image: 'item1.PNG'
    },
    {
        no: 2,
        productNm: '와 아이스크림.',
        qty: 1,
        price: 22000,
        image: 'item2.PNG'
    },
    {
        no: 3,
        productNm: '모나카 케익.',
        qty: 1,
        price: 13600,
        image: 'item3.PNG'
    }
]

// 숫자 3자리 콤마찍기
Number.prototype.formatNumber = function () {
    if (this == 0) return 0;
    let regex = /(^[+-]?\d+)(\d{3})/;
    let nstr = (this + '');
    while (regex.test(nstr)) nstr = nstr.replace(regex, '$1' + ',' + '$2');
    return nstr;
};