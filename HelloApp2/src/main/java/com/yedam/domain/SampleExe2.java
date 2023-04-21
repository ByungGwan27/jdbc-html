package com.yedam.domain;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.notice.mapper.NoticeMapper;
import com.yedam.notice.domain.NoticeVO;

public class SampleExe2 {
	public static void main(String[] args) {

		SqlSessionFactory sqlSessionFactory = 
				com.yedam.common.DataSource.getInstance();

		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			NoticeMapper mapper = session.getMapper(NoticeMapper.class);
			
//			Employee empl = new Employee();
//			empl.setEmployeeId(310);
//			empl.setLastName("Hong");
//			empl.setEmail("hon1@email");
//			empl.setJobId("IT_PROG");
			
//			mapper.addEmp(empl); //insert 처리
//			session.commit(); //commit 처리 or true
//			
//			Employee emp = mapper.getEmp(310);
//			System.out.println(emp);
			
			
			//2부
			
			NoticeVO nvo = new NoticeVO();
//			//추가
//			nvo.setNoticeWriter("user04");
//			nvo.setNoticeTitle("제목제목입니다.");
//			nvo.setNoticeSubject("본문본문입니다.");
//			mapper.insertNotice(nvo);
			
//			//수정
//			nvo.setNoticeId(5);
//			nvo.setNoticeTitle("제목제 입니다.");
//			nvo.setNoticeSubject("본문본 입니다.");
//			mapper.updateNotice(nvo);
			
//			//삭제
//			mapper.deleteNotice(5);
			
//			//단건 조회
//			System.out.println(mapper.searchNotice(3));
			
			//전체 조회
			for (NoticeVO vo : mapper.noticeList()) {
				System.out.println(vo);
			}
		}
		
		
		
	}
}
