package com.tistory.luahius.service;

import java.util.Map;

public interface BoardService {
		public int addBoard(Board board);

		Map<String, Object> getBoardListPerCurrentPage(int currentPage);
	}

