package com.yedam.domain;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class SampleExe {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = com.yedam.common.DataSource.getInstance();
		try (SqlSession session = sqlSessionFactory.openSession(true)) {//openSession(true)하면db에서 자동 commit
//			  Employee emp = session.selectOne("com.yedam.common.NoticeMapper.getEmp", 100);
//			  System.out.println(emp);
//			  session.delete("com.yedam.common.NoticeMapper.delEmp",208);
			  Employee emp1 = new Employee();
			  emp1.setEmployeeId(301);
			  emp1.setLastName("Hong");
			  emp1.setEmail("hong2@email.com");
			  emp1.setJobId("IT_PROG");
			  session.insert("com.yedam.common.NoticeMapper.addEmp",emp1);
//			  System.out.println();
//			  List<Employee> emp2 = session.selectList("com.yedam.common.NoticeMapper.empList");
//			  System.out.println(emp2);
		}
	}
}
