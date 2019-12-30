package com.king.myweb.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.king.myweb.domain.BoardVO;
import com.king.myweb.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public void write(BoardVO boardVO) throws Exception {
		boardDAO.write(boardVO);
	}

}
