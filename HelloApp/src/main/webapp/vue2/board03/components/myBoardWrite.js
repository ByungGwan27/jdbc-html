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
      console.log('1');
      let dataArray = this.$route.getDataArray();
      console.log(dataArray);
      let no = 1;
      if(dataArray.length != 0) {
        let index = dataArray.length - 1;
        no = parseInt(dataArray[index].no) + 1;//json은 객체 모양이지만 type은 String
      }
      let board_info = {
        'no' : no,
        'title' : this.title,
        'content' : this.content,
        'view' : 0
      }
      
      dataArray.push(board_info);
      
      this.$parent.setDataArray(dataArray);
      this.$router.push({ name : 'boardList'});
      
      console.log(this.title);
      console.log('3');
  
      fetch('http://192.168.0.51:8081/myserver/boardInsert')
        .then(response => response.json())
        .then(data => {
          console.log(data);
          console.log(this);
          console.log('2');
          //this.object = data;
          //this.object.push(board_info);
        })
        .catch(err => console.log(err));

    },
  } 
}