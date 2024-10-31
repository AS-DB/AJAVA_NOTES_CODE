<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*" %>
<%@ page errorPage="error.jsp" %> <!-- Set the error page -->
<!DOCTYPE html>
<html>
<head>
    <title>Exception use in JSP</title>
</head>
<body>
    <h2>Exception Handling in JSP</h2>
    <%
        try {
            int result = 10 / 0; 
            out.println("<p>Result: " + result + "</p>");
        } catch (Exception e) {
            out.println("<h3>An error occurred:</h3>");
            
            //error message
            out.println("<p>Message: " + e.getMessage() + "</p>"); 
            out.println("<h4>Stack Trace:</h4>");
            out.println("<pre>");
         
            // printStackTrace()
            e.printStackTrace(new PrintWriter(out)); 
            out.println("</pre>");

            // Display the cause of the error
            Throwable cause = e.getCause();
            if (cause != null) {
                out.println("<p>Cause: " + cause.getMessage() + "</p>");
            } else {
                out.println("<p>Cause: No specific cause available.</p>");
            }
            response.sendRedirect("error.jsp");
        }
    %>
    <br>
    <a href="index.jsp">Go Back</a>
</body>
</html>

