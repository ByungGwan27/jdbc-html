package com.yedam.notice.service;

import java.util.List;

import com.yedam.notice.domain.ReplyVO;

public interface ReplyService {
	public List<ReplyVO> getReplies(int noticeId);
	public boolean addReply(ReplyVO vo);
	public boolean removeReply(int replyId);
	
	public boolean modifyReply(ReplyVO vo);
	//public boolean modifyReply(@Param("replyId") int replyId, @Param("reply") int reply);
	public ReplyVO getReply(int replyId);
}
