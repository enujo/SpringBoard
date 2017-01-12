package com.tistory.luahius.service;

import org.springframework.web.multipart.MultipartFile;

public class FileBoardCommand {
	private String title;
	private String auth;
	private MultipartFile multipartFile;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	@Override
	public String toString() {
		return "FileBoardCommand.java [title=" + title + ", auth=" + auth + ", multipartFile=" + multipartFile + "]";
	}
	
	
}
