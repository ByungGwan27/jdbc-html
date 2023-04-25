package com.yedam.notice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.notice.domain.ReplyVO;

public interface ReplyMapper {
	public List<ReplyVO> replyList(int noticeId);
	
	// 댓글등록.
	public int insertReply(ReplyVO vo);
	
	//댓글삭제.
	public int deleteReply(int replyId);
	
	//댓글수정
//	public int updateReply(@Param("replyId") int replyId, @Param("reply") int reply); // 파라미터 바로 사용하는 방식(서비스에도 기입) -> xml의 파라미터타입 안적어도됨
	public int updateReply(ReplyVO vo);
	
	public ReplyVO searchReply(int replyId);
}
