package com.yedam.notice.service;

import java.util.List;

import com.yedam.notice.domain.NoticeVO;

public interface NoticeService {
	//CRUD(입력,수정,삭제,조회) create,read,update,delete
	public List<NoticeVO> noticeList();
	public boolean addNotice(NoticeVO vo);
	public boolean modifyNotice(NoticeVO vo);
	public boolean removeNotice(int noticeId);
	public NoticeVO getNotice(int noticeId);
}
