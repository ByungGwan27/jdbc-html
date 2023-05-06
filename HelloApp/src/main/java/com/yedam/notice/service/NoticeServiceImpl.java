package com.yedam.notice.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.mapper.NoticeMapper;

public class NoticeServiceImpl implements NoticeService {

	SqlSession session = DataSource.getInstance().openSession(true); //자동 커밋
	NoticeMapper mapper = session.getMapper(NoticeMapper.class);
	
	//조회에서 페이징 조회로 바뀜
	@Override
	public List<NoticeVO> noticeList(int page) {
//		return mapper.noticeList();
		return mapper.noticeWithPage(page);
	}

	@Override
	public boolean addNotice(NoticeVO vo) {
		return mapper.insertNotice(vo) == 1; //1건 입력되면 true, 아니면 false
	}

	@Override
	public boolean modifyNotice(NoticeVO vo) {
		return mapper.updateNotice(vo) == 1;
	}

	@Override
	public boolean removeNotice(int noticeId) {
		return mapper.deleteNotice(noticeId) == 1;
	}

	@Override
	public NoticeVO getNotice(int noticeId) {
		// 조회수 증가.
		mapper.updateCount(noticeId);  //조회수 증가시키고
		return mapper.searchNotice(noticeId); //증가시킨 조회수 조회
	}
	
	@Override
	public int totalCount() {
		return mapper.getCount();
	}

}
