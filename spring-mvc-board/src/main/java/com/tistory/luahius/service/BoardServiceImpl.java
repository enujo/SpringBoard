package com.tistory.luahius.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public int addBoard(Board board) {

		return boardDao.insertBoard(board);
	}
	
	@Override
	public Map<String, Object> getBoardListPerCurrentPage(int currentPage){
		//pagePerRow, beginRow 를 구하고 
		int pagePerRow = 10;
		int beginRow = (currentPage-1)*pagePerRow;
		
		//토탈카운트를 구하고
		int totalRowCount = boardDao.selectTotalBoardCount();

		int lastPage = totalRowCount/pagePerRow;
        if(totalRowCount%pagePerRow != 0) {
            lastPage++;
        }

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("beginRow", beginRow);
        map.put("pagePerRow", pagePerRow);
        
		List<Board> list = boardDao.selectBoardListPerPage(map);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("totalCount", totalRowCount);
		returnMap.put("lastPage", lastPage);
		returnMap.put("list", list);
		return returnMap;
	}

	@Override
	public Board viewBoard(int boardNo) {
		Board board = boardDao.selectBoardByKey(boardNo);
		return board;
	}

	@Override
	public int removeBoard(Board board) {
		
		return boardDao.deleteBoard(board);
	}

	@Override
	public int modifyBoard(Board board) {
		return boardDao.updateBoard(board);
	}


}

