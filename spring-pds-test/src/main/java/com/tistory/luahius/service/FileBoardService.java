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
		//1) ���丮 ����
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
			multipartFile.transferTo(destFile);//�갡 Exception ����Ŵ
			
			//2) FileBoardCommand -> FileBoard -> DAO
			FileBoard fileBoard = new FileBoard();	//new �����ڸ� ��� ���Ϸ��� �Ű������� �޾Ƶ� �ȴ� ������������ ��ü�� ������ִϱ�
			fileBoard.setTitle(fileBoardCommand.getTitle());
			fileBoard.setAuth(fileBoardCommand.getAuth());
			fileBoard.setFilePath(path);
			fileBoard.setFileName(fileName);
			fileBoard.setExtention(extention);
			//{}�ȿ� ������ ����
			logger.info("������ ������ {} �Դϴ�", fileBoard.toString());
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
