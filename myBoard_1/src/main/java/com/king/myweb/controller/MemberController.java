package com.king.myweb.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.king.myweb.domain.MemberVO;
import com.king.myweb.service.MemberService;


@Controller
@RequestMapping("/member/*")
public class MemberController {
	
private static final Logger logger = LoggerFactory.getLogger(MemberController.class);	
	@Inject
	MemberService service;
	
	//회원가입 get
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void getRegister() throws Exception{
		logger.info("get register");
		
	}
	
	//회원가입 post
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(MemberVO memberVO) throws Exception{
		logger.info("post register");
		
		service.register(memberVO); 
		
		return "redirect:/";
	}
	
	//로그인
	@RequestMapping(value = "/login" ,method = RequestMethod.POST)
	public String login(MemberVO memberVO, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		
		logger.info("post login");
		HttpSession session = req.getSession();
		
		MemberVO login = service.login(memberVO); 
		
		if (login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		}else {
			session.setAttribute("member", login);
		}
		return "redirect:/";
	}
	
}
