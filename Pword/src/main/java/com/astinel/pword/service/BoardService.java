package com.astinel.pword.service;

import java.util.List;

import com.astinel.pword.domain.BoardVO;
import com.astinel.pword.domain.Criteria;

public interface BoardService {
    /* 게시판 등록 */
    public void enroll(BoardVO board);
    
    /* 게시판 목록 */
    public List<BoardVO> getList();
    
	/* 게시판 목록 페이징 */
    public List<BoardVO> getListPaging(Criteria cri);
    
    /* 게시판 조회 */
    public BoardVO getPage(int bno);
    
    /* 게시판 수정 */
    public int modify(BoardVO board);
    
	/* 게시판 삭제 */
    public int delete(int bno);
    
	/* 게시판 총 개수 */
    public int getTotal(Criteria cri);
}
