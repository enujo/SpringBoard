package com.tistory.luahius.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tistory.luahius.service.FileBoardCommand;
import com.tistory.luahius.service.FileBoardService;

@Controller
public class FileBoardController {
	private static final Logger logger = LoggerFactory.getLogger(FileBoardController.class);
	
	@Autowired
	private FileBoardService fileBoardService;
	
	
	@RequestMapping(value="/detail")
	public String detail(){
		logger.debug("Controller : GET detail ...");
		return "detail";
	}
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String add(){
		logger.debug("Controller : GET add ...");
		return "add";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(FileBoardCommand fileBoardCommand){
		logger.debug("Controller : POST add ...");
		logger.info(fileBoardCommand.toString());
		fileBoardService.addFileBoard(fileBoardCommand);
		return "redirect:list";
	}
	
	@RequestMapping(value="/list")
	public String list(Model model, @RequestParam(value="currentPage", defaultValue="1")int currentPage){
		logger.debug("Controller : list ...");
		Map<String, Object> returnMap = fileBoardService.getBoardListPerCurrentPage(currentPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalRowCount", returnMap.get("totalRowCount"));
		model.addAttribute("lastPage", returnMap.get("lastPage"));
		model.addAttribute("list", returnMap.get("list"));
		return "list";
	}
}
