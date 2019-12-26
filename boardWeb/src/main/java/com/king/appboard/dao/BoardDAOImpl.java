package com.king.appboard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.king.appboard.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
		
	}
	
	// 1. 글 목록 
	@Override
	public List<BoardVO> list() {
		return sqlSessionTemplate.selectList("list");
	}

	//2. 글쓰기 
	@Override
	public void insert(BoardVO boardVO) {
		sqlSessionTemplate.insert("insert", boardVO);
	}

	//3. 상세보기 
	@Override
	public BoardVO read(int seq) {
		return sqlSessionTemplate.selectOne("read", seq);
		
	}



}
