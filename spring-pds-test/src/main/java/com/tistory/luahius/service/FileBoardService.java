package com.tistory.luahius.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tistory.luahius.controller.FileBoardController;

@Service
public class FileBoardService {
	private static final Logger logger = LoggerFactory.getLogger(FileBoardController.class);
	public int addFileBoard(FileBoardCommand fileBoardCommand){
		//1) 디렉토리 저장
		String path = "";
		String fileName = "";
		File destFile = null;
		String extention = "";
		
	
		try {
			path = "D:\\REXOLUA\\Google Drive\\TPSH\\workspace-sts\\spring-pds-test\\src\\main\\resources\\upLoad\\";
			MultipartFile multipartFile = fileBoardCommand.getMultipartFile();
			UUID uuid = UUID.randomUUID();
			fileName = uuid.toString().replace("-","");
			int index = multipartFile.getOriginalFilename().lastIndexOf(".");
			extention = multipartFile.getOriginalFilename().substring(index+1);
			fileName = fileName+"."+extention;
			destFile = new File(path+fileName);
			multipartFile.transferTo(destFile);//얘가 Exception 일으킴
			
			//2) FileBoardCommand -> FileBoard -> DAO
			FileBoard fileBoard = new FileBoard();	//new 연산자를 사용 안하려면 매개변수로 받아도 된다 스프링에서는 객체를 만들어주니까
			fileBoard.setTitle(fileBoardCommand.getTitle());
			fileBoard.setAuth(fileBoardCommand.getAuth());
			fileBoard.setFilePath(path);
			fileBoard.setFileName(fileName);
			fileBoard.setExtention(extention);
			//{}안에 내용이 들어간다
			logger.info("파일의 내용은 {} 입니다", fileBoard.toString());
		} catch (IllegalStateException e) {
			destFile.delete();
			e.printStackTrace();
		} catch (IOException e) {
			destFile.delete();
			e.printStackTrace();
		}
		
		return 0;
		
	}
}
