package com.king.appboard.service;

import java.util.List;

import com.king.appboard.domain.BoardVO;

public interface BoardService {
	
	// 1. 글 목록 
	public abstract List<BoardVO> list();

	//2. write.jsp
	public abstract void write(BoardVO boardVO);

	public abstract BoardVO read(int seq);
	
//	public abstract int delete(BoardVO boardVO);
	
//	public abstract int edit(BoardVO boardVO);

//	public abstract BoardVO read(int seq);

}
