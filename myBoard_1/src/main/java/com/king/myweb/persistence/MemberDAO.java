package com.king.myweb.persistence;

import com.king.myweb.domain.MemberVO;

public interface MemberDAO {
	
	//회원가입
	public void register(MemberVO memberVO) throws Exception;
	
	//로그인
	public MemberVO login(MemberVO memberVO) throws Exception;
}
