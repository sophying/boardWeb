package com.king.appboard.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.king.appboard.dao.BoardDAO;
import com.king.appboard.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Resource
	private BoardDAO boardDao; 
	
	// 1. 글 목록 
	@Override
	public List<BoardVO> list() {
		return boardDao.list();
	}

	// 2. write 글쓰기 
	@Override
	public void write(BoardVO boardVO) {
		boardDao.insert(boardVO);
	}

	// 3. 상세보기
	@Override
	public BoardVO read(int seq) {
		
		return boardDao.read(seq);
	}

	// 3. 상세보기 


}
