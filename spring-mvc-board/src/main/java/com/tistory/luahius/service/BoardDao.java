package com.tistory.luahius.service;

import java.util.List;
import java.util.Map;

public interface BoardDao {
	//�������̽��� �żҵ�� public �߻�޼ҵ� �ۿ� �����´� �׷��� ����
	int insertBoard(Board board);
	
	int selectTotalBoardCount();
	List<Board> selectBoardListPerPage(Map<String, Integer> map);

}
