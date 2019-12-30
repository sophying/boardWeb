package com.king.myweb.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.king.myweb.domain.BoardVO;
import com.king.myweb.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	
//	@Inject
//	ReplyService RepServie;
	
	//글 작성 get
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void getWrite(HttpSession session, Model model) throws Exception{
		logger.info("get write");
		
		Object loginInfo = session.getAttribute("member");
		
		if (loginInfo == null) {
			model.addAttribute("msg", false);
		}
		
	}
	
	
	//글 작성 post
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWrite(BoardVO boardVO)throws Exception{
		logger.info("post write");
		
		service.write(boardVO);
		
		return "redirect:/";
		
	}
	
}
