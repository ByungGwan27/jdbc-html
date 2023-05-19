package com.yedam.notice.control;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;

public class ModifyNoticeFileControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
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
		String nid = multi.getParameter("nid");
		System.out.println(nid);
		
		return "HaHaHa.json";
	}

}
