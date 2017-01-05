package com.tistory.luahius.service;

import java.util.List;
import java.util.Map;

public interface BoardDao {
	//인터페이스의 매소드는 public 추상메소드 밖에 못갖는다 그래서 생략
	int insertBoard(Board board);
	
	int selectTotalBoardCount();
	List<Board> selectBoardListPerPage(Map<String, Integer> map);

}
