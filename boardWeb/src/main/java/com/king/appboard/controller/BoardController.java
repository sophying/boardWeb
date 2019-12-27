package com.king.appboard.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.king.appboard.domain.BoardVO;
import com.king.appboard.service.BoardService;

/*
	 @RequestMapping("/board/*") 을 클래스에 적용해주지 않았다면 
	 1. 각각의 메소드에 @RequestMapping("/board/list.do") 을 작성해줄 것
	 2. 경로는 /board/를 시작으로 작성 할 것  
	 
	 @RequestMapping("/board/*") 을 클래스에 적용하였다면,
	 1. 각각의 메소드에 @RequestMapping("list.do") 을 작성해줄 것
	 
	 model.addAttribute(boardService.list()); 로 작성하여도 가능 
	 이유는 boardService.list() 반환되는 값 자체가 BoardVO 의 형태를 띄고 있으므로 
	 알아서 해당 클래스명을  카멜형식으로 변환하여 아이디를 생성해줌 
	 
*/
@Controller
@SessionAttributes("boardVO")  // @Alias("boardVO") 동일 해야함 
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
	/* @Valid BoardVO  :  @Lenth/ @NotEmpty 를 적용한 클래스 임을 알림 */
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String write(@Valid BoardVO boardVO, BindingResult bindingResult) {  // @Alias("boardVO") 이름 동일 할 것 
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
//	@RequestMapping(value = "board/read", method = RequestMethod.GET)   
	/* jsp에서 값을 /board/read?seq=${board.seq} 로 넘길 경우    BoardController 매개변수로는 @RequestParam 활용하여 값 전달 받기  */
	@RequestMapping(value = "board/read/{seq}", method = RequestMethod.GET)
	public String read(@PathVariable int seq, Model model) {
		BoardVO boardList = boardService.read(seq);
		model.addAttribute("boardList",boardList); // model.addAttribute("boardVO",boardService.read(seq)); 
		return "/board/read";
		
	}
	

	// 4. 내용 수정 페이지를 읽어오기 
	@RequestMapping(value = "/board/edit/{seq}",method = RequestMethod.GET)
	public String edit(@PathVariable int seq, Model model) {
		BoardVO boardList = boardService.read(seq);
		model.addAttribute("boardVO",boardList);  // <form:form modelAttribute="boardVO"  이름 동일 
		
		return "/board/edit";
	}

	// 5. 수정 @Alias("boardVO") 이름 동일 할 것 
	@RequestMapping(value = "/board/edit/{seq}", method = RequestMethod.POST) // POST  서버가 처리할 수 있는 자료 전송 
	public String edit(@Valid @ModelAttribute BoardVO boardVO, BindingResult bindingResult, int pwd, SessionStatus sessionStatus, Model model) {
		if (bindingResult.hasErrors()) {
			return "/board/edit";
		}else {
			if (boardVO.getPassword() == pwd) {
				boardService.edit(boardVO);
				sessionStatus.setComplete();
				return "redirect:/board/list";
			}
			
			model.addAttribute("msg", "소삐님, 비밀번호가 일치하지 않습니다.");
			return "/board/edit";
		}
		
	}
	// 6. 삭제 
	@RequestMapping(value = "/board/delete/{seq}", method = RequestMethod.GET)  // GET   url 에 해당하는 자료를 전송
	public String delete(@PathVariable int seq) {
		boardService.delete(seq);  
		return "redirect:/board/list";
	}
/*
	@ModelAttribute : 자동으로 해당 객체를 뷰까지 전달하도록 만든 것
*/
}
