package com.board.example.controller;

import java.util.List;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.example.dto.BoardDTO;
import com.board.example.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	BoardService boardService; 
	

	//1.현재 자주 쓰이는 Model 클래스를 DI 하는 방법
	@RequestMapping("list.do")
	public String boatdList(Model model) throws Exception{
		
		List<BoardDTO> list = boardService.boardList(); //list 변수에 결과 값 담음 
		model.addAttribute("list",list); //model 에 데이터 값을 담음 model 객체가 가지고 있는 메소드 addAttribute("key", "value")를 활용하기 위함 
		return "board/board_list"; // board / board_list.jsp 로 이동
	}
	
	/*
		과거 ModelAndView 를 활용한 방법
		
		@RequestMapping("list.do")
		public ModelAndView boardMenu() throws Exception{
			List<BoardDTO> list = boatdService.boardList();
			ModelAndView mav = new ModelAndView();
			mav.setViewName("board/board_list");
			mav.addObject("list",list);
			return mav; // board/board_list.jsp 로 이동
		
		}
	 */
	
	//2.게시글 상세내용 불러오기
	/*  "read.do" 인식이 되면 아래 메소드를 실행 하라 */
	@RequestMapping(value = "read.do", method= RequestMethod.GET)
	public String boardRead(@RequestParam int bno, Model model) throws Exception{
		BoardDTO data = boardService.boardRead(bno); // bno 값을 넘김
//		boardService.viewUpdate(bno);    // 조회수 업데이트 
		model.addAttribute("data",data); // model 에 데이터 값을 담음  -> 해당 데이터는 board_read 로 이동
		return "board/board_read";// board/board_read.jsp 로 이동
		
	}
	
//___3. writer_page.jsp 매핑
	@RequestMapping("writer_page")
	public String writerpage() {
		return "board/writer_page";
		
	}
	
//___3. 게시글 form  데이터 처리
	@RequestMapping(value = "insert.do", method= RequestMethod.POST)
	public String boardWriter(BoardDTO bdto) throws Exception{
		boardService.writerBoard(bdto);
		return "redirect:list.do";  //리스트로 redirect
		
	}
	
//___4. 게시글 수정 페이지로 이동 ( 수정 버튼 누를 경우 )
	@RequestMapping(value = "updatepage", method = RequestMethod.GET)
	public String boardUpdate(@RequestParam int bno, Model model) throws Exception{
		BoardDTO data = boardService.boardRead(bno); // bno 값을 넘김
		model.addAttribute("data", data); // model 에 데이터 값을 담음
		return "board/board_update"; // board/board_update.jsp 로 이동
	}
	
//___4. 게시글 수정 실행  ( 수정 완료를 한 뒤 버튼을 누를 경우 )
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String boardUpdatedo(BoardDTO bdto) throws Exception{
		boardService.updateBoard(bdto); 
		return "redirect:list.do";  //리스트로 redirect
	}
	
//___5. 게시글 삭제 실행 
	@RequestMapping(value = "delete.do", method = RequestMethod.GET)
	public String boardDeletedo(@RequestParam int bno) throws Exception{
		boardService.deleteBoard(bno); 
		return "redirect:list.do";  //리스트로 redirect
	}
	
	
	
}
