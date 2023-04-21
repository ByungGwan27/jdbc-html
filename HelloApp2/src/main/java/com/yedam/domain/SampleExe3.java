package com.yedam.domain;

import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;

public class SampleExe3 {
	public static void main(String[] args) {
		//서비스 로직 테스트
		NoticeService service = new NoticeServiceImpl();
		
		for(NoticeVO vo : service.noticeList()) {//목록 가져오기
			System.out.println(vo);
		}
		
	}
}
