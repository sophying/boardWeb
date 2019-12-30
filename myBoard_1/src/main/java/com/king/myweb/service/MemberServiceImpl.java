package com.king.myweb.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.king.myweb.domain.MemberVO;
import com.king.myweb.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject
	private MemberDAO memberDAO;  // root-context 에서 Scan 되어있음 
	
	//1.  회원가입
	@Override
	public void register(MemberVO memberVO) throws Exception {
		
		memberDAO.register(memberVO);
	}

	//2.  로그인
	@Override
	public MemberVO login(MemberVO memberVO) throws Exception {
		
		return memberDAO.login(memberVO);
	}

	//3.  회원정보 수정 
	@Override
	public void modify(MemberVO memberVO) throws Exception {
		memberDAO.modify(memberVO);
	}

	//4.  회원탈퇴 
	@Override
	public void withdrawal(MemberVO memberVO) throws Exception {
		memberDAO.withdrawal(memberVO);
	}

}
