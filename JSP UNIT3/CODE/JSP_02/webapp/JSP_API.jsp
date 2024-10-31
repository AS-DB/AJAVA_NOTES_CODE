<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP API</title>
</head>
<body>
    <h1>Key component of JSTL are being used</h1>
    
    <%-- Declaration--%>
    <%! public int calculateCube(int number) { return number * number * number; } %>

    <%-- Scriptlet --%>
    <%
        int number = 3;
        String user = "ADITYA DAS";
        session.setAttribute("userName", user);
    %>
	<!-- Expression -->
    <p>The current date and time is: <%= new Date() %></p> 
    <p>The cube of <%= number %> is: <%= calculateCube(number) %></p>
   

	<!-- implicit object method -->
    <p>Username from session: <%= session.getAttribute("userName") %></p>

    
    <!-- JSTL Method -->
    <c:forEach var="i" begin="1" end="5">
        <p>Item <c:out value="${i}" /></p>
    </c:forEach>
</body>
</html>
