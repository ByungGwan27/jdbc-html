package com.yedam.member.mapper;

import com.yedam.member.domain.MemberVO;

public interface MemberMapper {
	
	//로그인 조회
	public MemberVO loginCheck(MemberVO vo);
	
	//회원 정보 수정
	public int updateMember(MemberVO vo);
	
}
