<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
</head>
<body>
    <div>��ü���� �� : ${totalRowCount}</div>
    <table border="1">
        <thead>
            <tr>
                <th>Title</th>
                <th>Auth</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="b" items="${list}">
                <tr>
                    <td><a href="<c:url value='/detail?boardNo=${b.fileNo}'/>">${b.title}</a></td>
                    <td>${b.auth}</td>
                    <td><a href=""></a>�ٿ�ε�</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
 
    <div>
        <a href="<c:url value='add'/>">�Խñ� �Է�</a>
    </div>
    <div>
        <c:if test="${currentPage>1}">
            <a href="<c:url value='list?currentPage=${currentPage-1}'/>">����</a>
        </c:if>
        <c:if test="${currentPage < lastPage}"> 
            <a href="<c:url value='list?currentPage=${currentPage+1}'/>">����</a>
        </c:if>
 
    </div>
</body>
</html>
