package com.yedam.common;

import java.util.List;

import com.yedam.domain.Employee;
import com.yedam.notice.domain.NoticeVO;

public interface NoticeMapper {
	public Employee getEmp(int empId);
	public List<Employee> empList();
	public int delEmp(int empId); /*메소드이름과 타입형태가 메퍼에 있는것과 같아야함*/
	public int addEmp(Employee emp);
}
