package com.board.example.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.example.dao.BoardDAO;
import com.board.example.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	BoardDAO boardDao;
	
	@Override
	public List<BoardDTO> boardList() throws Exception {
		return boardDao.boardList();
	}

	// 2. boardRead() 메소드 생성되면 override 진행
	@Override
	public BoardDTO boardRead(int bno) throws Exception {
		
		// 상세보기 진행됨과 동시에 조회수 업데이트 
		boardDao.viewCount(bno); 
		return boardDao.boardRead(bno);
	}

	//3. 게시물 글 쓰기
	@Override
	public void writerBoard(BoardDTO bdto) throws Exception {
		boardDao.writerBoard(bdto);  
		
	}

	//4. 게시물 수정 
	@Override
	public void updateBoard(BoardDTO bdto) throws Exception {
		boardDao.boardUpdate(bdto);
	}

	//5. 게시물 삭제
	@Override
	public void deleteBoard(int bno) throws Exception {
		boardDao.boardDelete(bno);
		
	}
	
	//6.조회수 업데이트
	@Override
	public void viewUpdate(int bno) throws Exception {
		boardDao.viewCount(bno);
	}



}
