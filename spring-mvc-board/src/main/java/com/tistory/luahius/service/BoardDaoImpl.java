package com.tistory.luahius.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertBoard(Board board) {

		return sqlSession.insert("com.tistory.luahius.BoardMapper.boardAdd", board);
	}
	

}
