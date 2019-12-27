package com.king.appboard.dao;

import java.util.List;

import com.king.appboard.domain.BoardVO;

public interface BoardDAO {
	
	// 1. 글 목록 
	public abstract List<BoardVO> list();

	// 2. write 글쓰기 
	public abstract void insert(BoardVO boardVO);

	// 3. 상세보기 
	public abstract BoardVO select(int seq);

	// 4. 조회수 
	public abstract int updateReadCount(int seq);

	// 5. 수정등록 할 경우 
	public abstract int update(BoardVO boardVO);

	public abstract void delete(int seq);
	
//	public abstract int delete(BoardVO boardVO);
	
//	public abstract int deleteAll();
	
	
}
