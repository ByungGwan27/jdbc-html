package com.yedam.member.service;

import java.util.List;

import com.yedam.member.domain.EventVO;

public interface EventService {
	// 이벤트 목록
	public List<EventVO> events();
	// 이벤트 등록
	public boolean addEvent(EventVO envet);
	// 이벤트 삭제
	public boolean removeEvent(EventVO event);
}
