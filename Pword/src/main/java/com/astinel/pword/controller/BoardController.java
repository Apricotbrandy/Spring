package com.astinel.pword.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.astinel.pword.domain.BoardVO;
import com.astinel.pword.domain.Criteria;
import com.astinel.pword.domain.PageMakerDTO;
import com.astinel.pword.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
@Controller
public class BoardController {
	private BoardService service;

	/* 게시판 목록 페이지 접속 */
//	@GetMapping("/list")
//	public void boardGetList(Model model) {
//		log.info("get list in board");
//		model.addAttribute("list", service.getList());
//	}
	
	/* 게시판 목록 페이지 접속(페이징 적용) */
	@GetMapping("/list")
	public void boardGetList(Model model, Criteria cri) {
		log.info("get board list");
		
		model.addAttribute("list", service.getListPaging(cri));
		
		int total = service.getTotal(cri);
		
		PageMakerDTO pageMaker = new PageMakerDTO(cri, total);
		model.addAttribute("pageMaker", pageMaker);
	}
	
	/* 게시판 등록 페이지 이동 */
	@GetMapping("/enroll")
	public void boardEnroll() {
		log.info("into enroll page");
	}
	
    /* 게시판 등록 */
    @PostMapping("/enroll")
    public String boardEnrollPOST(BoardVO board, RedirectAttributes rttr) {
        
        log.info("BoardVO : " + board);
        service.enroll(board);
        log.info("BoardVO : " + board);
        
        rttr.addFlashAttribute("result","enroll success");
        
        return "redirect:/board/list";
    }
    
    /* 게시판 조회 */
    @GetMapping("/get")
    public void boardGetPageGET(int bno, Model model,Criteria cri) {
        
        model.addAttribute("pageInfo", service.getPage(bno));
        model.addAttribute("cri", cri);
        
    }
    
    /* 수정 페이지 이동 */
    @GetMapping("/modify")
    public void boardModifyGET(int bno, Model model, Criteria cri) {
        
        model.addAttribute("pageInfo", service.getPage(bno));
        
        model.addAttribute("cri", cri);
        
    }
    
    /* 페이지 수정 */
    @PostMapping("/modify")
    public String boardModifyPOST(BoardVO board, RedirectAttributes rttr) {
        
        service.modify(board);
        
        rttr.addFlashAttribute("result", "modify success");
        
        return "redirect:/board/list";
        
    }
    
	/* 페이지 삭제 */
    @PostMapping("/delete")
    public String boardDeletePOST(int bno, RedirectAttributes rttr) {
    	service.delete(bno);
    	rttr.addFlashAttribute("result", "delete success");
    	return "redirect:/board/list";
    }
    
    
    
}
