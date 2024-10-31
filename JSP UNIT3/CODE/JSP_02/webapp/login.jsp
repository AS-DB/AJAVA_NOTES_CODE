<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.Cookie" %>
<!DOCTYPE html>
<html>
<head>
    <title>Response</title>
</head>
<body>
    <h2>Password=1234 and username=aditya</h2>

    <%
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("aditya".equals(username) && "1234".equals(password)) {
            // Set a session attribute for the logged-in user
            session.setAttribute("username", username);

            // Create a cookie
            Cookie userCookie = new Cookie("username", username);
            userCookie.setMaxAge(60 * 60 * 24); 
            response.addCookie(userCookie); 

            // Redirect to welcome page
            response.sendRedirect("welcome.jsp");
        } else {
            out.println("<p>Invalid username or password. Please try again.</p>");
            out.println("<a href='login.html'>Go back to login</a>");
        }
    %>
</body>
</html>
