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
import com.yedam.notice.service.ReplyService;
import com.yedam.notice.service.ReplyServiceImpl;

public class RemoveReplyControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rid = req.getParameter("rid"); //xhtp.send('rid')를 가져옴
		ReplyService service = new ReplyServiceImpl();
		String json = "";
		
		if (service.removeReply(Integer.parseInt(rid))) {
			json = "{\"retCode\":\"Success\"}"; //뒤에 Success값은 임의 지정 가능 ex) ok, yes...
		} else {
			json = "{\"retCode\":\"Fail\"}";
		}
		
		return json + ".json";
	}

}
