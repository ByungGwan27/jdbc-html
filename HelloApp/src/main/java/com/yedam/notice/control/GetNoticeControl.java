package com.yedam.notice.control;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;

public class GetNoticeControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO param: nid
		
		String nid = req.getParameter("nid"); //noticeList ?뒤의 파라미터 변수명 일치 해줘야함 -> 이방식으로 get
		String page = req.getParameter("page");
		
		NoticeService service = new NoticeServiceImpl();
		NoticeVO vo = service.getNotice(Integer.parseInt(nid));
		req.setAttribute("noticeInfo", vo);
		req.setAttribute("pageNum", page);
		
		//첨부파일이 있으면...?
		//첨부파일의 타입을 체크
		
		if (vo.getAttachFile() != null) {
			String imgPath = req.getServletContext().getRealPath("images");
			Path file = Paths.get(imgPath + "/" + vo.getAttachFile());
			System.out.println(Files.probeContentType(file)); //probeContentType : 해당 이미지의 타입을 보여주는 메소드
			// image/jpg, image/png, text/plain,
			String fileType = Files.probeContentType(file);
			req.setAttribute("fileType", fileType.substring(0, fileType.indexOf("/")));//0부터 시작해서 "/"값 앞까지 잘라주기 위해서
			
		}
		
		return "notice/noticeGet.tiles";
	}

}
