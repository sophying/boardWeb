package com.king.appboard.dao;

import java.util.List;

import com.king.appboard.domain.BoardVO;

public interface BoardDAO {
	
	// 1. 글 목록 
	public abstract List<BoardVO> list();

	// 2. write 글쓰기 
	public abstract void insert(BoardVO boardVO);

	public abstract BoardVO read(int seq);
	
//	public abstract int delete(BoardVO boardVO);
	
//	public abstract int deleteAll();
	
//	public abstract int update(BoardVO boardVO);
	
//	public abstract BoardVO select(int seq);
	
//	public abstract int updateReadCount(int seq);

}
