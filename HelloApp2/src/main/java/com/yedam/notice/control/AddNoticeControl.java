package com.yedam.notice.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;

public class AddNoticeControl implements Control {

	@Override
	public String execuet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파일업로드 , db 입력처리, 목록으로 이동하는 기능
		// 멀티파트요청하면 > 업로드됨
		// 멀티파트요청: 요청정보, 저장경로, 최대파일크기(사이즈), 인코딩 방식,
		// 리네임정책(같은 파일을 올리면 뒤에 올린 파일명 바꾸기)인스턴스 가 필요함
		// 객체를 만들어주기만 하면 업로드 처리가 됨
		
		// 실제경로 찾기 = getRealPath(폴더명); 업로드하기 = getServletContext()
		String saveDir = req.getServletContext().getRealPath("images");
		
		
		int maxSize = 5 * 1024 * 1024; //5는 5MB를 뜻함 총 용량
		String encoding = "UTF-8";
		DefaultFileRenamePolicy rn = new DefaultFileRenamePolicy(); //같은 파일명을 사용시 파일명을 바꿔줌
		MultipartRequest multi = new MultipartRequest(req, saveDir, maxSize, encoding, rn); 
		// db parameter읽어오기
		String writer = multi.getParameter("writer"); //"" db에 있는 값들
		String subject = multi.getParameter("subject");
		String title = multi.getParameter("title");
		// 서버에 업로드되고나면 바뀐 이름을 가지고와야됨
		String attach = multi.getFilesystemName("attach");

		// 사용자의 입력값을 NoticeVO 입력.
		NoticeVO vo = new NoticeVO();
		vo.setAttachFile(attach);
		vo.setNoticeSubject(subject);
		vo.setNoticeTitle(title);
		vo.setNoticeWriter(writer);

		NoticeService service = new NoticeServiceImpl();
		if(service.addNotice(vo)) {
			return "noticeList.do";
		}else {
			return "main.do";
		}
	}

}