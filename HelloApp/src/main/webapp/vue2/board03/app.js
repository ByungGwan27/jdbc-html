import router from './router/router.js';

let template = `
  <div>
    <h2>간단한게시판</h2>
    <router-view></router-view>
  </div>`;

new Vue({
  el : '#app',
  template : template,
  router // router : router의 약어
})