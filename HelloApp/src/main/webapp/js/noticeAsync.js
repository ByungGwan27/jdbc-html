/**
 * noticeAsync.js 
 */
// async function()...

async function loadData() {
	let promise = await fetch('noticeListJson.do');
	let promise1 = promise.json();
}

document.addEventListener('DOMContentLoaded', function () {
	loadData();
})