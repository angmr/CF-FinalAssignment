<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Επιτυχής Εισαγωγή</title>
</head>
<body>
	<h1>Doctor inserted successfully</h1>
	<div>
		<p>${inserteddoctor.fname}</p>
		<p>${inserteddoctor.sname}</p>
	</div>
	
	<a href="${pageContext.request.contextPath}/jsps/doctorsmenu.jsp">Επιστροφή στο Μενού</a>
</body>
</html>