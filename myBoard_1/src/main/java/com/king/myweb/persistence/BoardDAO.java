package com.king.myweb.persistence;

import com.king.myweb.domain.BoardVO;

public interface BoardDAO {
	
	//글 작성
	public void write(BoardVO boardVO) throws Exception;

}
