package com.yedam.notice.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;

public class ModifyNoticeJsonControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//5.22 9:40
		// id, title, subject 받아와서 값을 변경.
		int id  = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String subject = req.getParameter("subject");
		
		NoticeVO vo = new NoticeVO();
		vo.setNoticeId(id);
		vo.setNoticeTitle(title);
		vo.setNoticeSubject(subject);
		
		// id를 기준으로 한건 변경된 값을 조회.
		NoticeService service = new NoticeServiceImpl();
		Map<String, Object> map = new HashMap<>();
		Gson gson = new GsonBuilder().create();
		
		if (service.modifyNotice(vo)) {
			map.put("retCode", "Success");
			map.put("retVal", service.getNotice(id));//한 번 더 조회를 위해
			
		} else {
			map.put("retCode", "Fail");
			map.put("retVal", null);
		}
		return gson.toJson(map) + ".json";
		
		
	}

}
