<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일 입력</h1>
	<form enctype="multipart/form-data" action="add" method="post">
		<div>
			<label for="title">TITLE:</label>
			<input type="text" name="title" id="title"/>
		</div>
		<div>
			<label for="auth">AUTH:</label>
			<input type="text" name="auth" id="auth"/>
		</div>
		<div>
			<label for="multipartFile">FIEL:</label>
			<input type="file" name="multipartFile" id="multipartFile"/>
		</div>
		<div><button>파일입력</button></div>
	</form>
</body>
</html>