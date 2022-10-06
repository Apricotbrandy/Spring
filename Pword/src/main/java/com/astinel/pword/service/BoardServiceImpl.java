package com.astinel.pword.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astinel.pword.domain.BoardVO;
import com.astinel.pword.domain.Criteria;
import com.astinel.pword.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService{
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	/* 게시판 등록 */
	@Override
	public void enroll(BoardVO board) {
		mapper.enroll(board);
		log.info("enroll success");
	}
	
	/* 게시판 목록 */
	@Override
	public List<BoardVO> getList(){
		return mapper.getList();
	}
	
	/* 게시판 목록 페이징 */
	@Override
    public List<BoardVO> getListPaging(Criteria cri){
		return mapper.getListPaging(cri);
	}
	
	/* 게시판 조회 */
	@Override
    public BoardVO getPage(int bno) {
		return mapper.getPage(bno);
	}
	
    /* 게시판 수정 */
    @Override
    public int modify(BoardVO board) {
    	log.info("modify success");
        return mapper.modify(board);
    }
    
	/* 게시판 삭제 */
    public int delete(int bno) {
    	return mapper.delete(bno);
    }
    
	/* 게시판 총 개수 */
    public int getTotal(Criteria cri) {
    	return mapper.getTotal(cri);
    }
}
