package com.king.appboard.service;

import java.util.List;
import com.king.appboard.domain.BoardVO;

public interface BoardService {
	
	// 1. 글 목록 
	public abstract List<BoardVO> list();

	//2. write.jsp
	public abstract void write(BoardVO boardVO);

	//3. 상세보기  (수정할 때, 상세보기 )
	public abstract BoardVO read(int seq);

	//4. 수정 
	public abstract int edit(BoardVO boardVO);

	//5. 삭제 
	public abstract void delete(int seq);


}
