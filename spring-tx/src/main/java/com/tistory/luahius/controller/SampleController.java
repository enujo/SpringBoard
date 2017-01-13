package com.tistory.luahius.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tistory.luahius.Sample;
import com.tistory.luahius.SampleService;

@Controller
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@Autowired
	private SampleService sampleService;
	
	@RequestMapping(value="/add")
	public String addSample() {
		logger.debug(" addSample ing... ");
		Sample sample = new Sample();
		int y = ((int)(Math.random()*10));
		logger.debug( " y의 값은 [{}] 입니다. ",y);
		sample.setY(y);
		sampleService.addSample(sample);
		
		return "redirect:/";
	}
}
