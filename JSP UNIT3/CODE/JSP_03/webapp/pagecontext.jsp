<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <title>PageContext Handling</title>
</head>
<body>
    <h2>PageContext Example</h2>
    <%
        // Get parameters from the request
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        // Set attributes in different scopes using PageContext methods
        pageContext.setAttribute("username", name, PageContext.PAGE_SCOPE); // Page scope
        pageContext.setAttribute("userage", age, PageContext.REQUEST_SCOPE); // Request scope

        // Retrieve attributes from specific scopes
        String username = (String) pageContext.getAttribute("username", PageContext.PAGE_SCOPE);
        String userage = (String) pageContext.getAttribute("userage", PageContext.REQUEST_SCOPE);

        // Display the retrieved name and age
        out.println("<p>Name (Page Scope): " + (username != null ? username : "No name provided") + "</p>");
        out.println("<p>Age (Request Scope): " + (userage != null ? userage : "No age provided") + "</p>");

        // Example of removing an attribute from a specific scope
        pageContext.removeAttribute("username", PageContext.PAGE_SCOPE); // Remove from Page scope
        out.println("<p>Username has been removed from Page Scope.</p>");

        // Get the session object using PageContext
        HttpSession s1 = pageContext.getSession();
        s1.setAttribute("sessionMessage", "This is stored in session."); // Store in session

        // Retrieve the request object
        HttpServletRequest currentRequest = (HttpServletRequest) pageContext.getRequest();
        String clientIP = currentRequest.getRemoteAddr(); // Get client IP

        // Retrieve the response object
        HttpServletResponse currentResponse = (HttpServletResponse) pageContext.getResponse();
        // Set content type using response object
        currentResponse.setContentType("text/html");

        // Display client IP
        out.println("<p>Client IP: " + clientIP + "</p>");

        // Show session message
        String sessionMessage = (String) s1.getAttribute("sessionMessage");
        out.println("<p>Session Message: " + (sessionMessage != null ? sessionMessage : "No message") + "</p>");
    %>
    <br>
    <a href="index.jsp">Go Back</a>
</body>
</html>

