export default {
  name : 'my-board-read',
  template : `<div>
                  <table id="list">
                    <tr>
                        <td style="width:50px;">글제목</td>
                        <td>{{ board.title }}</td>
                    </tr>
                    <tr style="height:300px">
                      <td colspan="2">{{ board.content }}</td>
                    </tr>
                  </table>
                  <!--<router-link tag="button" style="float:right;" to="/">목록</router-link>-->
                  <router-link tag="button" style="float:right;" v-bind:to="{ name : 'boardList' }">목록</router-link>
              </div>`,
  data :function() {
    return {
      board : {}
    }
  },
  props : ['item'],//라우터에서 path에 변수명을 item으로 설정함
  created : function () {
    fetch('http://192.168.0.51:8081/myserver/boardInfo?no=' + this.item.no)
    .then(response => response.json())
    .then(data => {
      this.board = data;
    })
    .catch(err => console.log(err));
  }
}