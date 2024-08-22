package com.board.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BoardDao {

	// SqlSessionFactory를 SqlMapConfig를 통하여 생성한다.
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;

	public BoardDao() {
		// SqlSessionFactory에서 session을 할당받는다.
		// 이 때 openSession에 true를 주어야 자동 커밋이 된다.
		// default는 false이다.
		session = sqlsession_f.openSession(true);
	}

	public int countBoard2() {
		BoardMapper bm = session.getMapper(BoardMapper.class);
		return bm.countBoard();
	}

	public List<BoardDto> getAllBoards() {
		BoardMapper boardMapper = session.getMapper(BoardMapper.class);
		return boardMapper.selectAll();
	}

	public BoardDto getBoardById(int num) {
		BoardMapper boardMapper = session.getMapper(BoardMapper.class);
		return boardMapper.selectById(num);
	}

	public void addBoard(BoardDto boardDto) {
		BoardMapper boardMapper = session.getMapper(BoardMapper.class);
		boardMapper.insertBoard(boardDto);
	}

	public void updateBoard(BoardDto boardDto) {
		BoardMapper boardMapper = session.getMapper(BoardMapper.class);
		boardMapper.updateBoard(boardDto);
	}

	public void deleteBoard(int num) {
		BoardMapper boardMapper = session.getMapper(BoardMapper.class);
		boardMapper.deleteBoard(num);
	}
	
	public List<BoardDto> pageBoard(int start,int end) {
		BoardMapper boardMapper = session.getMapper(BoardMapper.class);
		return boardMapper.selectBoardsWithPagination(start, end);
	}
}
