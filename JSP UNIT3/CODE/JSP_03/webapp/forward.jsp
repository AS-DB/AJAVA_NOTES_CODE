<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Source Page with Parameters</title>
</head>
<body>
    <h2>Welcome to the Source Page with Parameters</h2>

    <jsp:forward page="target.jsp">
        <jsp:param name="user" value="ADITYA_DAS" />
        <jsp:param name="age" value="19" />
    </jsp:forward>
</body>
</html>

