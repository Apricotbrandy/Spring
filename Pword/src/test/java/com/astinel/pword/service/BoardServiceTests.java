package com.astinel.pword.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.astinel.pword.domain.BoardVO;
import com.astinel.pword.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
//	@Test
//	public void testEnroll() {
//		BoardVO vo = new BoardVO();
//		
//		vo.setTitle("service test");
//		vo.setContent("service test");
//		vo.setWriter("service test");
//
//		service.enroll(vo);
//		log.info("(service test) ==============:3");
//	}
	
	
	/* 게시판 목록 테스트 */
//	@Test
//	public void testGetList(){
//		service.getList().forEach(board -> log.info("board"+board));
//	}
	
    /*게시판 조회*/
//    @Test
//    public void testGETPage() {
//        
//        int bno = 8;
//        
//        log.info("" + service.getPage(bno));
//        
//    }

    /* 게시판 수정 */
//    @Test
//    public void testModify() {
//        
//        BoardVO board = new BoardVO();
//        board.setBno(8);
//        board.setTitle("수정 제목");
//        board.setContent("수정 내용");
//        
//        int result = service.modify(board);
//        log.info("result : " + result);
//        
//    }     
	
	/* 게시판 삭제 */
//	@Test
//	public void testDelete() {
//		int result = service.delete(12);
//		log.info("result : " + result);
//	}
	
	
	/* 게시판 목록 페이징 */
	@Test
	public void testGetListPaging() {
		Criteria cri = new Criteria();
		
		List list = service.getListPaging(cri);
		
		list.forEach(board -> log.info("" + board));
	}
}
