package com.tistory.luahius.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String BOARD_NS="com.tistory.luahius.BoardMapper."; 
	@Override
	public int insertBoard(Board board) {

		return sqlSession.insert(BOARD_NS+"boardAdd", board);
	}

	@Override
	public int selectTotalBoardCount() {
		return sqlSession.selectOne(BOARD_NS+"selectTotalBoardCount");
	}

	@Override
	public List<Board> selectBoardListPerPage(Map<String, Integer> map) {
		return sqlSession.selectList(BOARD_NS+"selectBoardListPerPage", map);
	}

}
