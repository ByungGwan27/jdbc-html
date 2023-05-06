package com.yedam.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.member.mapper.MemberMapper;
import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.mapper.NoticeMapper;

public class SampleExe2 {
	public static void main(String[] args) {
		
		SqlSessionFactory sqlSessionFactory =
				com.yedam.common.DataSource.getInstance();
		
		try (SqlSession session = sqlSessionFactory.openSession(true)) {
//			NoticeMapper mapper = session.getMapper(NoticeMapper.class);
//			NoticeVO nvo = new NoticeVO();
//			nvo.setNoticeId(4);
//			nvo.setNoticeWriter("user00");
//			nvo.setNoticeTitle("re:tttest");
//			nvo.setNoticeSubject("re:글내용입니다....아.");
//			mapper.insertNotice(nvo);
////			mapper.updateNotice(nvo);
////			mapper.deleteNotice(4);
////			System.out.println(mapper.searchNotice(3));
//
//			for (NoticeVO vo : mapper.noticeList()) {
////				System.out.println(vo);
//			}
			
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			
			List<Map<String, Object>> list = mapper.memberByDept();
			// [{Adminstration, 1}, {Accounting, 2}....{}]
			
			for (Map<String, Object> map : list) {
				Set<String> set = map.keySet();
//				for (String key : set) {
//					System.out.println(key + " : " + map.get(key));
					System.out.println(map.get("DEPARTMENT_NAME") + ", " + map.get("CNT"));
//				}
				
			}
			
			
//			//내가 쓴것
//			NoticeMapper mapper = session.getMapper(NoticeMapper.class);
			
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
			
//			NoticeVO nvo = new NoticeVO();
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
//			for (NoticeVO vo : mapper.noticeList()) {
//				System.out.println(vo);
//			}
			
			
			
		}
		
	}
}
