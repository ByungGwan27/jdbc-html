package com.yedam.domain;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class SampleExe {
	
	public static void main(String[] args) {

		SqlSessionFactory sqlSessionFactory =
				com.yedam.common.DataSource.getInstance();//DataSource에서 static 선언한것 불러오기)
		try (SqlSession session = sqlSessionFactory.openSession(true/*자동 커밋*/)) { //세션을 열때 commit, rollback을 해줘야함
			
//			//사원 한명 조회
//			Employee emp = session.selectOne("com.yedam.common.NoticeMapper.getEmp"/*주소 변경*/, 100);
//			//삭제
//			session.delete("com.yedam.common.NoticeMapper.delEmp", 213);
//			session.delete("com.yedam.common.NoticeMapper.delEmp", 220); //이 문장만으로 삭제됨
			
//			//사원 추가
			Employee empl = new Employee();
			empl.setEmployeeId(300);
			empl.setLastName("Hong");
			empl.setEmail("hon@email");
			empl.setJobId("IT_PROG");
			session.insert("com.yedam.common.NoticeMapper.addEmp", empl);
			
			//사원 전체 조회
			List<Employee> emp = session.selectList("com.yedam.common.NoticeMapper.empList");
			System.out.println(emp); //셋팅이 완료됐는지 확인
		}
		// 분석
		//com.yedam.common.NoticeMapper.addEmp
		//클래스 이름 : com.yedam.common.NoticeMapper
		//메소드 이름 : addEmp

	}
}
