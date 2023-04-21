package com.yedam.notice.mapper;

import java.util.List;

import com.yedam.domain.Employee;
import com.yedam.notice.domain.NoticeVO;

public interface NoticeMapper {
	public Employee getEmp(int empId);
	public List<Employee> empList();
	public int delEmp(int empId); /*메소드이름과 타입형태가 메퍼에 있는것과 같아야함*/
	public int addEmp(Employee emp);
	
	// 공지사항. CRUD: 입력, 조회, 수정, 삭제, 목록
	public List<NoticeVO> noticeList(); //목록 가져오기
	public int insertNotice(NoticeVO vo); //입력
	public int updateNotice(NoticeVO vo); // 수정
	public int deleteNotice(int noticeId); //삭제
	public NoticeVO searchNotice(int noticeId); //단건조회
	// 조회수증가.
	public int updateCount(int noticeId);
	
}
