<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Updated</title>
</head>
<body>

    <h1>New Doctor information</h1>
    <p>${doctor.fname}</p>
    <p>${doctor.sname}</p>
    <a href="${pageContext.request.contextPath}/jsps/doctorsmenu.jsp">Back</a>

</body>
</html>