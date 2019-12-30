package com.king.myweb.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.king.myweb.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	//mybatis
	@Inject
	private SqlSession sql;
	
	//Mapper
	private static String namespace = "com.king.myweb.mappers.boardMapper";

	//글 작성
	@Override
	public void write(BoardVO boardVO) throws Exception {
		sql.insert(namespace+".write", boardVO);
	}
	

}
