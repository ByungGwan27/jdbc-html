package com.yedam.notice.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;

public class NoticeListControl implements Control {

	@Override
	public String execuet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		NoticeService service = new NoticeServiceImpl();
		List<NoticeVO> list = service.noticeList(); //목록을 가져오고 결과값을 넣음
		
		req.setAttribute("list"/*list라는 어트리뷰트*/, list); //요청 정보를 담아 아래 return 페이지로 보내줌
										//FrontController의 viewPage변수에 들어감
		
//		return "WEB-INF/views/notice/noticeList.jsp"; //tilse적용 안하겠다는 뜻(확장자가 jsp이기 때문)
		return "noticeList.tiles"; //tiles라는 것으로 주소 재지정
	}

}
