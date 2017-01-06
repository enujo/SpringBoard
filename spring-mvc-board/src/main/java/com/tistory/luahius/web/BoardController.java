package com.tistory.luahius.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tistory.luahius.service.Board;
import com.tistory.luahius.service.BoardService;


@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board/boardAdd", method=RequestMethod.GET)
	public String boardAdd(){
		return "/board/boardAdd"; //forward
	}
	
	//오버로딩
	@RequestMapping(value="/board/boardAdd", method=RequestMethod.POST)
	public String boardAdd(Board board){//커맨드 객체
		System.out.println(board);
		boardService.addBoard(board);
		return "redirect:/board/boardList";
	}
	
	@RequestMapping(value="/board/boardList")
	public String boardList(Model model,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage){
		Map<String, Object> returnMap = 
				boardService.getBoardListPerCurrentPage(currentPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalRowCount", returnMap.get("totalRowCount"));
		model.addAttribute("lastPage", returnMap.get("lastPage"));
		model.addAttribute("list", returnMap.get("list"));
		return "/board/boardList";
	}
	@RequestMapping(value="/board/boardView", method=RequestMethod.GET)
	public String boardView(Model model, @RequestParam(value="boardNo") int boardNo){
		System.out.println("boardView :"+boardNo);
		Board board = boardService.viewBoard(boardNo);
		model.addAttribute("board", board);
		System.out.println("boardView :"+board);
		return "/board/boardView";
	}
	@RequestMapping(value="/board/boardRemove", method=RequestMethod.GET)
	public String boardRemove(Model model,@RequestParam(value="boardNo") int boardNo){
		if(boardNo == 0){
			return "redirect:/board/boardList";			
		}else{
			model.addAttribute("boardNo", boardNo);
			return "/board/boardRemove";
		}
	}
	@RequestMapping(value="/board/boardRemove", method=RequestMethod.POST)
	public String boardRemove(Board board){
		System.out.println("Remove : \n"+board);
		boardService.removeBoard(board);
		return "redirect:/board/boardList";
	}
	@RequestMapping(value="/board/boardModify", method=RequestMethod.GET)
	public String boardUpdate(Model model,@RequestParam(value="boardNo") int boardNo){
		Board board = boardService.viewBoard(boardNo);
		model.addAttribute("board", board);
		return "/board/boardModify";
	}

	@RequestMapping(value="/board/boardModify", method=RequestMethod.POST)
	public String boardUpdate(Board board){//커맨드 객체
		System.out.println(board);
		boardService.modifyBoard(board);
		return "redirect:/board/boardList";
	}
}
