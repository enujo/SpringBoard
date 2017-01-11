package com.tistory.luahius.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tistory.luahius.service.FileBoardCommand;
import com.tistory.luahius.service.FileBoardService;

@Controller
public class FileBoardController {
	private static final Logger logger = LoggerFactory.getLogger(FileBoardController.class);
	
	@Autowired
	private FileBoardService fileBoardService;
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String add(){
		return "add";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(FileBoardCommand fileBoardCommand){
		logger.info(fileBoardCommand.toString());
		fileBoardService.addFileBoard(fileBoardCommand);
		return "redirect:/";
	}
	
}
