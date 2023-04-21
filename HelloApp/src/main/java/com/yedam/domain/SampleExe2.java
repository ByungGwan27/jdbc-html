package com.yedam.domain;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.mapper.NoticeMapper;

public class SampleExe2 {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = //
				com.yedam.common.DataSource.getInstance();
		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			NoticeMapper mapper = session.getMapper(NoticeMapper.class);
			NoticeVO nvo = new NoticeVO();
			nvo.setNoticeId(4);
			nvo.setNoticeWriter("user00");
			nvo.setNoticeTitle("re:tttest");
			nvo.setNoticeSubject("re:글내용입니다....아.");
			mapper.insertNotice(nvo);
//			mapper.updateNotice(nvo);
//			mapper.deleteNotice(4);
//			System.out.println(mapper.searchNotice(3));

			for (NoticeVO vo : mapper.noticeList()) {
//				System.out.println(vo);
			}
		}
	}
}
