package com.king.myweb.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
	
	//1. 회원가입 get  : register.jsp 로 이동 화면 띄움 
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void getRegister() throws Exception{
		logger.info("---------------get register");
		
	}
	
	//2. 회원가입 post  : 가입정보를 입력 후 가입버튼을 눌렀을 경우  ( 값을 전달 )
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(MemberVO memberVO) throws Exception{
		logger.info("---------------post register");
		
		service.register(memberVO); 
		
		return "redirect:/";
	}
	
	//3. 로그인  : session 값에 담아 실행   
	/* 로그인 동시에  session.setAttribute  */
	@RequestMapping(value = "/login" ,method = RequestMethod.POST)
	public String login(MemberVO memberVO, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		
		logger.info("---------------post login");
		HttpSession session = req.getSession();
		
		MemberVO login = service.login(memberVO); 
		
		if (login == null) {
			session.setAttribute("member", null); // login 값을 담음  
			rttr.addFlashAttribute("msg", false);
		}else {
			session.setAttribute("member", login);
		}
		return "redirect:/";
	}
	
	//회원 정보 수정 get
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void getModify() throws Exception{
		logger.info("---------------get modify");
	}
	
	//회원 정보 수정 post
	@RequestMapping(value = "/modify",method = RequestMethod.POST)
	public  String postModify(HttpSession session, MemberVO memberVO) throws Exception{
		logger.info("---------------post modify");
		
		service.modify(memberVO); // 값을 update 한 뒤 memberVO 에 값을 넣어 두고 
		
		session.invalidate();  // 기존의 session 을 없앤 뒤, 값을 새롭게 받음 
		
		return "redirect:/";
	}
	
	//회원탈퇴  get  : 탈퇴를 위해 화면을 띄울 때 
	@RequestMapping(value ="/withdrawal",method = RequestMethod.GET)
	public void getWithdrawal() throws Exception{
		logger.info("---------------get withdrawal");
		
	}
	
	//회원탈퇴  post   : 탈퇴를 눌렀을 때 ( 값을 가지고 전달 할 때 )
	@RequestMapping(value ="/withdrawal",method = RequestMethod.POST)	
	public String postWithdrawal(HttpSession session, MemberVO memberVO, RedirectAttributes rttr) throws Exception{
		
		logger.info("---------------post withdrawal");
		
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		String oldPass = member.getUserPass();
		System.out.println(oldPass);
		String newPass = memberVO.getUserPass();
		
		if (!(oldPass.equals(newPass))) {
			rttr.addFlashAttribute("msg",false);
			return "redirect:/";
		}
		
		service.withdrawal(memberVO);  // delete 실행후
		session.invalidate();  // session 초기화 
		return "redirect:/";
	}
	
	//로그아웃 
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		logger.info("---------------get logout");
		session.invalidate();
		return "redirect:/";
		
	}
	
}
