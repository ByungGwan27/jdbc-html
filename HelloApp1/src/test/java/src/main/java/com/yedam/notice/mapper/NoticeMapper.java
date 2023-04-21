package com.yedam.notice.mapper;

import java.util.List;

import com.yedam.domain.Employee;
import com.yedam.notice.domain.NoticeVO;

public interface NoticeMapper {
	public Employee getEmp(int empid);
	public List<Employee> empList();
	public int delEmp(int empId);
	public int addEmp(Employee emp);
	
	//공지사항. CRUD: 입력,조회,수정,삭제,목록
	//목록
	public List<NoticeVO> noticeList();
	//추가
	public int insertNotice(NoticeVO vo);
	//수정
	public int updateNotice(NoticeVO vo);
	//삭제
	public int deleteNotice(int noticeId);
	//단건조회
	public NoticeVO searchNotice(int noticeId);
}
