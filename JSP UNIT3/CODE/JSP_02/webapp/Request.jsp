<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Response Page</title>
</head>
<body>
    <h2>Response Page</h2>

    <%
        // getparameter
        String userName = request.getParameter("name"); // Name parameter from form
        String userAge = request.getParameter("age");   // Age parameter from form

        // Display the values name and age
        out.println("<p>Name: " + (userName != null ? userName : "No name provided") + "</p>");
        out.println("<p>Age: " + (userAge != null ? userAge : "No age provided") + "</p>");

        //getheader
        String userAgent = request.getHeader("User-Agent");
        out.println("<p>User-Agent: " + (userAgent != null ? userAgent : "No User-Agent provided") + "</p>"); // Display the header value

        // SetAttribute
        request.setAttribute("greeting", "Friend!");
        
        // GetAttribute
        String greetingMessage = (String) request.getAttribute("greeting");
        out.println("<p>Greeting: " + greetingMessage + "</p>"); // Display the retrieved greeting message

        // getsession
        HttpSession s1 = request.getSession();
        s1.setAttribute("sessionMessage", "This message is store in this session."); // Setting up a session
        String sessionMessage = (String) s1.getAttribute("sessionMessage"); // Retrieve the value of a session attribute
        out.println("<p>Session Message: " + sessionMessage + "</p>");// Display the retrieved session message
    %>
</body>
</html>
