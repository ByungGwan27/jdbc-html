package com.yedam.domain;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.notice.mapper.NoticeMapper;
import com.yedam.notice.domain.NoticeVO;

public class SampleExe2 {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = com.yedam.common.DataSource.getInstance();
		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			NoticeMapper mapper = session.getMapper(NoticeMapper.class);
			NoticeVO nvo = new NoticeVO();
//			nvo.setNoticeWriter("user05");
//			nvo.setNoticeTitle("다섯번째 제목");
//			nvo.setNoticeSubject("다섯번째 글 내용입니다.");
//			mapper.insertNotice(nvo);
//			System.out.println(nvo);
//			nvo.setNoticeId(4);
//			nvo.setNoticeTitle("네번째 제목");
//			nvo.setNoticeSubject("네번째 글 내용입니다.");
//			mapper.updateNotice(nvo);
//			System.out.println(nvo);
//			mapper.deleteNotice(4);
			nvo = mapper.searchNotice(3);
			System.out.println(nvo);
			//목록
			for(NoticeVO vo : mapper.noticeList()) {
				System.out.println(vo);
			}
			
		}
	}
}
