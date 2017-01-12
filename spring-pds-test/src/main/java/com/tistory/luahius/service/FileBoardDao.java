package com.tistory.luahius.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/*@Repository는 @Component+알파 기능을 한다 DAO역할을 하는 클래스는 요걸쓴다*/

@Repository
public class FileBoardDao {
	private static final Logger logger = LoggerFactory.getLogger(FileBoardDao.class);
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String BOARD_NS="com.tistory.luahius.FileBoardMapper."; 
	
	public int insertBoard(FileBoard fileBoard) {
		logger.debug("nsertBoard run..");
		return sqlSession.insert(BOARD_NS+"fileAdd", fileBoard);
	}
	
	public int selectTotalBoardCount() {
		logger.debug("selectTotalBoardCount run..");
		return sqlSession.selectOne(BOARD_NS+"selectTotalBoardCount");
	}

	public List<FileBoard> selectBoardListPerPage(Map<String, Integer> map) {
		logger.debug("selectBoardListPerPage run..");
		return sqlSession.selectList(BOARD_NS+"selectBoardListPerPage", map);
	}
}
