package com.king.myweb.persistence;

import com.king.myweb.domain.MemberVO;

public interface MemberDAO {
	
	//회원가입
	public void register(MemberVO memberVO) throws Exception;
	
	//로그인
	public MemberVO login(MemberVO memberVO) throws Exception;

	//3. 회원정보 수정 
	public void modify(MemberVO memberVO) throws Exception;

	//4. 회원 탈퇴 
	public void withdrawal(MemberVO memberVO) throws Exception ;
}
