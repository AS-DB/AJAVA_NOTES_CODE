<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Target Page</title>
</head>
<body>
    <h2>Welcome to the Target Page</h2>
    <p>User: <%= request.getParameter("user") %></p>
    <p>Age: <%= request.getParameter("age") %></p>
</body>
</html>

