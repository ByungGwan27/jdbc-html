package com.yedam.domain;

import java.util.List;

import com.yedam.notice.domain.ReplyVO;
import com.yedam.notice.service.ReplyService;
import com.yedam.notice.service.ReplyServiceImpl;

public class SampleExe3 {
	public static void main(String[] args) {
		//4.24
		ReplyService service = new ReplyServiceImpl();
		List<ReplyVO> list = service.getReplies(98);
		
		for(ReplyVO vo : list) {
			System.out.println(vo);
		}
		
		
		//4.21 주석처리
//		NoticeService service = new NoticeServiceImpl();

//		for (NoticeVO vo : service.noticeList()) {
//			System.out.println(vo);
//		}
		
//		//4.21 페이징 출력을 위해
//		SqlSessionFactory sqlSessionFactory = //
//				com.yedam.common.DataSource.getInstance();
//		
//		try (SqlSession session = sqlSessionFactory.openSession(true)) {
//			NoticeMapper mapper = session.getMapper(NoticeMapper.class);
//			
//			List<NoticeVO> list = mapper.noticeWithPage(1);
//			for(NoticeVO vo : list) {
//				System.out.println(vo);
//			}
//		}
	}
}
