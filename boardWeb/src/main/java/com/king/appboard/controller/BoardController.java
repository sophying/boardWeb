package com.king.appboard.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.king.appboard.domain.BoardVO;
import com.king.appboard.service.BoardService;

@Controller
@SessionAttributes("boardVO")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	public BoardService getBoardService() {
		return boardService;
		
	}
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	// 1. 글 목록 
	/* url 에 사용자가   http://localhost:8088/appboard/board/list  를 요청하면 list.jsp 로 이동 */
	@RequestMapping( value = "/board/list")
	public String list(Model model) {
		model.addAttribute("boardList", boardService.list());
		return "/board/list";
	}
	
	// 2.  글 목록 화면에서 글쓰기 버튼 누를 경우  ->  write.jsp   
	 /* url 에 사용자가   http://localhost:8088/appboard/board/write  를 요청하면 write.jsp 로 이동 */
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("boardVO", new BoardVO());
		return "/board/write";
		
	}
	
	// 2. 글 쓰기 작성 (write.jsp) 후 등록을 누를 경우 
	/*
	@Valid BoardVO  :  @Lenth/ @NotEmpty 를 적용한 클래스 임을 알림 
	*/
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String write(@Valid BoardVO boardVO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			// 만일 form 에 error 가 발견 되면 write.jsp 에 머물고 validation (@Lenth/ @NotEmpty) 을 출력 함  
			return"/board/write";
		}else {
			//정상적으로 입력이 되었다면 
			boardService.write(boardVO);
			return "redirect:/board/list";
		}
		
	}

	// 3. 상세보기
	@RequestMapping(value = "board/read", method = RequestMethod.GET)
	public String read(@RequestParam int seq, Model model) {
		BoardVO boardList = boardService.read(seq);
		model.addAttribute("boardList",boardList);
		return "/board/read";
		
	}
	
	
	// 4. 내용 수정 
	@RequestMapping(value = "/board/update",method = RequestMethod.GET)
	public String update(@RequestParam int seq, Model model) {
		BoardVO boardList = boardService.read(seq);
		model.addAttribute("boardList",boardList);
		
		return "board/update";
	}
	
	// 5. 수정

	
	
/*
	@RequestMapping( value = "/board/read/{seq}")
	public String read(Model model, @PathVariable int seq) {
		
		
	}
*/
}
