package com.tistory.luahius.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tistory.luahius.service.Board;
import com.tistory.luahius.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board/boardList")
	public String boardList(){
		return "/board/boardList";
	}
	@RequestMapping(value="/board/boardAdd", method=RequestMethod.POST)
	public String boardAdd(Board board){
		System.out.println(board);
		boardService.addBoard(board);
		return "redirect:/board/boardList";	//forward WEB-INF안에 .jsp로 포워드	이름만 맞으면 바인딩이 된다.
	}
	
	@RequestMapping(value="/board/boardAdd", method=RequestMethod.GET)
	public String boardAdd(){
		return "/board/boardAdd";	//forward WEB-INF안에 .jsp로 포워드
	}
}




