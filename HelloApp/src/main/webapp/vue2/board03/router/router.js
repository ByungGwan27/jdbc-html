import myBoardList from '../components/myBoardList.js';
import myBoardRead from '../components/myBoardRead.js';
import myBoardWrite from '../components/myBoardWrite.js';

export default new VueRouter ({
  routes : [
    // boardList 대신 기본으로 사용할 component <- main
    // boardList
    {
      path : '/',
      name : 'boardList',
      component : myBoardList
    },
    // boardRead
    {
      path : '/boardRead/:item',
      name : 'boardRead',
      component : myBoardRead,
      props : true
    },
    // boardWrite
    {
      path : '/boardWrite',
      name : 'boardWrite',
      component : myBoardWrite
    },
    // 기타
    {
      path : '*',
      redirect : '/'
    }
  ]
})