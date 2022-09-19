<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor deleted</title>
</head>
<body>

    <p>Doctor: ${doctor.id} ${doctor.fname} ${doctor.sname}</p>
    <a href="${pageContext.request.contextPath}/jsps/doctorsmenu.jsp">Επιστροφή</a>

</body>
</html>