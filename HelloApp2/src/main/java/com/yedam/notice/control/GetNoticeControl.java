package com.yedam.notice.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;

public class GetNoticeControl implements Control {

	@Override
	public String execuet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO param: nid
		
		String nid = req.getParameter("nid");
		
		NoticeService service = new NoticeServiceImpl();
		req.setAttribute("noticeInfo", service.getNotice(Integer.parseInt(nid)));
		
		return "notice/noticeGet.tiles";
	}

}
