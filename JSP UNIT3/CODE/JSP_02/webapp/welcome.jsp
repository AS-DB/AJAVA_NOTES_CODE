<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
    <h2>Welcome! User</h2>

    <%
        // Check for the username in session
        String username = (String) session.getAttribute("username");
        if (username != null) {
            out.println("<p>Welcome, " + username + "!</p>");
        } else {
            response.sendRedirect("login.html");
        }
    %>
</body>
</html>
