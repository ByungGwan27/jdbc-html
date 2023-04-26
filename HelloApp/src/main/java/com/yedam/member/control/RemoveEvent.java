package com.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.member.domain.EventVO;
import com.yedam.member.service.EventService;
import com.yedam.member.service.EventServiceImpl;

public class RemoveEvent implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		EventService service = new EventServiceImpl();
		String json = "";
		
		EventVO vo = new EventVO();
		vo.setTitle(title);
		
		if (service.removeEvent(vo)) {
			json = "{\"retCode\":\"Success\"}"; //뒤에 Success값은 임의 지정 가능 ex) ok, yes...
		} else {
			json = "{\"retCode\":\"Fail\"}";
		}
		
		return json + ".json";
	}

}
