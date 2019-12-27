package com.king.appboard.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.king.appboard.dao.BoardDAO;
import com.king.appboard.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Resource
	private BoardDAO boardDao;  // DB와 연결되어야 하므로 
	
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
		boardDao.updateReadCount(seq); // viewCount 조회
		return boardDao.select(seq);
	}

	// 4. 수정
	@Override
	public int edit(BoardVO boardVO) {
		return boardDao.update(boardVO); // 한사람의 레코드를 담아서 업데이트 
	}

	// 5. 삭제 
	@Override
	public void delete(int seq) {
		 boardDao.delete(seq);
	}



}
