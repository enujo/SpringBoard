package com.tistory.luahius.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tistory.luahius.controller.FileBoardController;

@Service
public class FileBoardService {
	
	private static final Logger logger = LoggerFactory.getLogger(FileBoardController.class);
	
	@Autowired
	private FileBoardDao fileBoardDao;
	
	public int addFileBoard(FileBoardCommand fileBoardCommand){
		System.out.println("FileBoardService : addFileBoard run ... ");
		//1) 디렉토리 저장
		String path = "";
		String fileName = "";
		File destFile = null;
		String extention = "";
		int re=0;
		try {
			
			path = "D:\\REXOLUA\\enujo\\GitHub\\SpringBoard\\spring-pds-test\\src\\main\\resources\\upLoad\\";
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
			re = fileBoardDao.insertBoard(fileBoard);
		} catch (IllegalStateException e) {
			destFile.delete();
			e.printStackTrace();
		} catch (IOException e) {
			destFile.delete();
			e.printStackTrace();
		}
		
		return re;
		
	}
	
	public Map<String, Object> getBoardListPerCurrentPage(int currentPage){
		//pagePerRow, beginRow 를 구하고 
		int pagePerRow = 5;
		int beginRow = (currentPage-1)*pagePerRow;
		
		//토탈카운트를 구하고
		int totalRowCount = fileBoardDao.selectTotalBoardCount();

		int lastPage = totalRowCount/pagePerRow;
        if(totalRowCount%pagePerRow != 0) {
            lastPage++;
        }

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("beginRow", beginRow);
        map.put("pagePerRow", pagePerRow);
        
		List<FileBoard> list = fileBoardDao.selectBoardListPerPage(map);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("totalRowCount", totalRowCount);
		returnMap.put("lastPage", lastPage);
		returnMap.put("list", list);
		return returnMap;
	}


}
