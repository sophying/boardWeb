package com.king.myweb.service;

import com.king.myweb.domain.MemberVO;

public interface MemberService {
	
	//회원가입
	public void register(MemberVO memberVO) throws Exception;

	//로그인
	public MemberVO login(MemberVO memberVO) throws Exception;
	
	//회원정보 수정
	
	//회원 탈퇴

}
