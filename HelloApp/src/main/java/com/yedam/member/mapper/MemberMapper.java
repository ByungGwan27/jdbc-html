package com.yedam.member.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.member.domain.MemberVO;

public interface MemberMapper {
	
	//로그인 조회
	public MemberVO loginCheck(MemberVO vo);
	
	//회원 정보 수정
	public int updateMember(MemberVO vo);
	
	//차트
	public List<Map<String, Object>> memberByDept(); //가져오는 건수가 한 건 이상이라 List. String 부서 Object 인원
	
}
