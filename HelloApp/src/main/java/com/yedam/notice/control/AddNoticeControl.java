package com.yedam.notice.control;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;

public class AddNoticeControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 파일업로드/ db 입력처리/ 목록이동하는 기능
		
		//5.19 ajax 작업
		String job = req.getParameter("job");
		//5.19 12:47 post방식 해결
		job = job == null ? "mulit" : "ajax";
		
		if(job.equals("ajax")) {
			String title = req.getParameter("title");
			String subject = req.getParameter("subject");
			String writer = req.getParameter("writer");
			String attach = req.getParameter("attach"); // input:file 인 경우.
			
			//기존 작업물 복붙
			NoticeVO vo = new NoticeVO();
			vo.setAttachFile(attach);
			vo.setNoticeSubject(subject);
			vo.setNoticeTitle(title);
			vo.setNoticeWriter(writer);

			NoticeService service = new NoticeServiceImpl();
			// 정상처리 -> 목록이동.
			// map => {retCode:Success, retVal:vo}
			//	   => {retCode:Fail, retVal:null}
			Map<String, Object> map = new HashMap<>();
			
			Gson gson = new GsonBuilder().create();
			if (service.addNotice(vo)) {
				map.put("retCode", "Success");
				map.put("retVal", vo);
				
				//return "Success.json";
			} else {
				map.put("retCode", "Fail");
				//map.put("retVal", null);
				map.put("retVal", "알수없는 에러발생");
				//return "Fail.json";
			}
			return gson.toJson(map) + ".json"; // 객체 => json문자열.
			
			
			
		} else {
			
		
			
		//5.19 ajax 작업 끝 뒤에 else } 있음 확인해보셈
		
		// 멀트파트요청: 요청정보, 저장경로, 최대파일사이즈, 인코딩, 리네임정책인스턴스.
		
		// 멀티파트요청하면 > 업로드됨
		// 멀티파트요청: 요청정보, 저장경로, 최대파일크기(사이즈), 인코딩 방식,
		// 리네임정책(같은 파일을 올리면 뒤에 올린 파일명 바꾸기)인스턴스 가 필요함
		// 객체를 만들어주기만 하면 업로드 처리가 됨
		
		// 실제경로 찾기 = getRealPath(폴더명); 업로드하기 = getServletContext()
		String saveDir = req.getServletContext().getRealPath("images");
		
		int maxSize = 5 * 1024 * 1024; //총 용량 5MB
		String encoding = "UTF-8"; // 전송할 데이터의 인코딩 방식
		DefaultFileRenamePolicy rn = new DefaultFileRenamePolicy(); //같은 파일명을 사용시 파일명을 바꿔주는 클래스
		MultipartRequest multi //
				= new MultipartRequest(req, saveDir, maxSize, encoding, rn);
		
		//업로드된 파일의 이름을 가져와서 출력
		Enumeration<?> enu = multi.getFileNames(); //?는 모든 유형, 제한되지 않은 유형을 가진 배열. 스레드에 안전한 구조(Vector, Hashtable이 주로 사용), List 데이터를 받아 새로운 구조로 다시 만듦, 유지보수등의 유연성이 좋음
		while (enu.hasMoreElements()) {
			String file = (String) enu.nextElement();
			System.out.println("file: " + file);
		}
		
		// db parameter읽어오기
		String writer = multi.getParameter("writer"); //"" db에 있는 값들
		String subject = multi.getParameter("subject"); //필드명 적으면됨(jsp)
		String title = multi.getParameter("title");
		// 서버에 업로드되고나면 바뀐 이름을 가지고와야됨
		String attach = multi.getFilesystemName("attach"); //서버에 저장된 파일의 이름을 가져오는 메서드
		
		// 사용자의 입력값을 NoticeVO 입력.
		NoticeVO vo = new NoticeVO();
		vo.setAttachFile(attach);
		vo.setNoticeSubject(subject);
		vo.setNoticeTitle(title);
		vo.setNoticeWriter(writer);

		NoticeService service = new NoticeServiceImpl();
//		// 정상처리 -> 목록이동.
//		if (service.addNotice(vo)) {
//			return "noticeList.do";
//		} else {
//			return "main.do";
//		}
		
		// 5.19 12:28
		// 위에거 복붙
		Map<String, Object> map = new HashMap<>();
		
		Gson gson = new GsonBuilder().create();
		if (service.addNotice(vo)) {
			map.put("retCode", "Success");
			map.put("retVal", vo);
			
		} else {
			map.put("retCode", "Fail");
			map.put("retVal", "알수없는 에러발생");
		}
		return gson.toJson(map) + ".json";
		
		
		
		}//endof job().

	} // end of method().

}//end of class().
