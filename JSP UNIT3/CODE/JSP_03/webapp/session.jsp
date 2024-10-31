<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <title>Session Handling</title>
</head>
<body>
    <h2>Session Handling</h2>
    <%
        // Create session
        HttpSession s1 = request.getSession();

        // Get name and age from request parameters
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        // Check if name and age are provided, then set them as session attributes
        if (name != null) {
            s1.setAttribute("username", name); // setAttribute
        }
        if (age != null) {
            s1.setAttribute("userage", age); // setAttribute
        }

        // Retrieve the attributes from the session
        String username = (String) s1.getAttribute("username"); 
        String userage = (String) s1.getAttribute("userage");   
        
        // Display the retrieved name and age
        out.println("<p>Name: " + (username != null ? username : "No name provided") + "</p>");
        out.println("<p>Age: " + (userage != null ? userage : "No age provided") + "</p>");

        // Remove an attribute (example: removing age)
        if (userage != null) {
            s1.removeAttribute("userage"); 
            out.println("<p>User age has been removed from session.</p>");
        }

        // Example of invalidating the session
        out.println("<form method='post' action='session.jsp?invalidate=true'>");
        out.println("<input type='submit' value='Invalidate Session'>");
        out.println("</form>");

        // Invalidate session if the request has the parameter "invalidate"
        String invalidateParam = request.getParameter("invalidate");
        if ("true".equals(invalidateParam)) {
            s1.invalidate(); // invalidate
            out.println("<p>Session has been invalidated.</p>");
        }
    %>
    <br>
    <a href="index.jsp">Go Back</a>
</body>
</html>

