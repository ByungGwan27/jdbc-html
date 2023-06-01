export default {
  name : 'my-board-write',
  template : `<div>
                  <table id="list">
                    <tr>
                        <td>글제목</td>
                        <td><input type="text" style="width:90%;" v-model="title"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <textarea style="width:100%;" v-model="content"></textarea>
                        </td>
                    </tr>
                  </table>
                  <router-link tag="button" style="float:right;" to="/boardList">목록</router-link>
                  <button style="float:right;" v-on:click="boardSave">저장</button>
            </div>`,
  data:function(){
    return {
      title : '',
      content : ''
    }
  },
  created: function () {
    
  },
  methods : {
    boardSave : function(){
      //fetch('http://192.168.0.51:8081/myserver/boardInsert?title=' + this.title + '&content=' + this.content)
      fetch('http://192.168.0.51:8081/myserver/boardInsert', {
        method : 'post',
        headers : {
          'Content-type' : 'application/json'
        },
        body : JSON.stringify({title : this.title, content : this.content})
        //body안에 데이터가 존재
      })
      .then(response => response.json())
      .then(data => {
        console.log(data);
        this.$router.push({ name : 'boardList'});//해당 페이지로 이동
      })
      .catch(err => console.log(err));
      
    },
  } 
}