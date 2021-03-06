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
		sqlSessionTemplate.insert("insert", boardVO);  // sqlSessionTemplate.insert("sqlmapID", 전달될 값); 
	}

	//3. 상세보기 
	@Override
	public BoardVO select(int seq) {
		BoardVO boardVO = sqlSessionTemplate.selectOne("read", seq);
		return boardVO;
		
	}

	// 4. 조회수 
	@Override
	public int updateReadCount(int seq) {
		return sqlSessionTemplate.update("updateCount", seq);
	}

	// 5. 수정내용 등록 
	@Override
	public int update(BoardVO boardVO) {
		return sqlSessionTemplate.update("update",boardVO);
	}

	// 6. 삭제 
	@Override
	public void delete(int seq) {
		 sqlSessionTemplate.delete("delete",seq);
	}



}
