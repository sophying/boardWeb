package com.king.myweb.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.king.myweb.domain.MemberVO;
import com.king.myweb.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject
	private MemberDAO memberDAO;
	
	//회원가입
	@Override
	public void register(MemberVO memberVO) throws Exception {
		
		memberDAO.register(memberVO);
	}

	//로그인
	@Override
	public MemberVO login(MemberVO memberVO) throws Exception {
		
		return memberDAO.login(memberVO);
	}

}
