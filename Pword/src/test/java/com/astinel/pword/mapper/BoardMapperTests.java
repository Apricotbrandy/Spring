package com.astinel.pword.mapper;

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
public class BoardMapperTests {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
//	@Test
//	public void testEnroll() {
//		BoardVO bvo = new BoardVO();
//		
//		bvo.setTitle("mapper title");
//		bvo.setContent("mappper content");
//		bvo.setWriter("mapper writer");
//		
//		mapper.enroll(bvo);
//	}
	
	 
	/* 게시판 목록 테스트 */
//     @Test
//     public void testGetList() {
//         
//         
//         List<BoardVO> list = mapper.getList();
//        /* 일반적 for문 */
//         for(int i = 0; i < list.size();i++) {
//             log.info("" + list.get(i));
//         }
         
        /* foreach문(향상된 for문) */
//         for(Object a : list) {
//             log.info("" + a);
//         }
         
        /* foreach문 & 람다식 */
//         list.forEach(board -> log.info("" + board));
         
//     }
     
	/* 게시판 조회 */
//     @Test
//     public void testGetPage() {
//        
//        /* 실제 존재하는 페이지 */
//        int bno = 8;
//        
//        log.info("" + mapper.getPage(bno));
//        
//    }     

	
	/* 게시판 수정 */
//	    @Test
//	    public void testModify() {
//	        
//	        BoardVO board = new BoardVO();
//	        board.setBno(8);
//	        board.setTitle("수정 제목");
//	        board.setContent("수정 내용");
//	        
//	        int result = mapper.modify(board);
//	        log.info("result : " +result);
//	        
//	    }	
	
	/* 게시판 삭제 */
//	@Test
//	public void testDelete() {
//		int result = mapper.delete(9);
//		log.info("result : " + result);
//	}
	
	/* 게시판 목록 페이징 적용 테스트 */
	@Test
    public void testGetListPaging() {
        
        Criteria cri = new Criteria();
        
        cri.setPageNum(2);
                         
        List list = mapper.getListPaging(cri);
        
        list.forEach(board -> log.info("" + board));
    }
     
}
