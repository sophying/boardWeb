package com.king.myweb.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.king.myweb.domain.MemberVO;

@Service
public class MemberDAOImpl implements MemberDAO{

	//마이바티스
	@Inject
	private SqlSession sql;
	
	//Mapper
	private static String namespace = "com.king.myweb.mappers.memberMapper";
	
	//회원가입
	@Override
	public void register(MemberVO memberVO) throws Exception {
		sql.insert(namespace+".register", memberVO);
	}

	@Override
	public MemberVO login(MemberVO memberVO) throws Exception {
		return sql.selectOne(namespace+".login", memberVO);
	}

}
