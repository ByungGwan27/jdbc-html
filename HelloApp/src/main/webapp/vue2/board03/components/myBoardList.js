export default {
  name: 'my-board-list',
  template: `<div>
                  <table id="list">
                      <tr>
                          <th style="width:50px;">글번호</th>
                          <th>글제목</th>
                          <th style="width:50px;">조회수</th>
                          <th style="width:70px;"></th>
                      </tr>
                      <tr v-for="item in object" v-bind:key="item.no">
                          <td>{{item.no}}</td>
                          <!--<td v-on:click="boardRead(item)">{{item.title}}</td>-->
                          <router-link tag="td"
                                        v-bind:to="{name : 'boardRead', params : {item : item} }">
                                        {{ item.title }}</router-link>
                          <td>{{item.view}}</td>
                          <td><button v-on:click="boardDelete(item.no)">삭제</button></td>
                      </tr>
                  </table>
                  <!--<button style="float:right;" v-on:click="boardWrite">글쓰기</button>-->
                  <router-link tag="button" style="float:right;" to="/boardWrite">글쓰기</router-link>
              </div>`,
  data: function () {
    return {
      object: [] //props를 보통 사용 못함
    }
  },
  created: function () {
    fetch('http://192.168.0.51:8081/myserver/boardAll')
    .then(response => response.json())
    .then(data => {
      this.object = data;
    })
    .catch(err => console.log(err));
  },
  methods: {
    boardDelete: function (no) {
      // fetch('http://192.168.0.51:8081/myserver/boardDelete', {
      //   method : 'post',
      //   body : { no : no }
      // })
      // .then(response => console.log(response.body))
      // .catch(err => console.log(err));

      fetch('http://192.168.0.51:8081/myserver/boardDelete?no='+no)
      .then(response => response.text())
      .then(data => console.log(data))
      .catch(err => console.log(err));

      // for (let i = 0; i < this.object.length; i++) {
      //   if (this.object[i].no == no) {
      //     this.object.splice(i, 1);
      //   }
      // }

      // this.$parent.setDataArray(this.object);
    }
  }
}