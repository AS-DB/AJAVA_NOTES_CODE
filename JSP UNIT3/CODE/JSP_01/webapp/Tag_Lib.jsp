<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSTL Tag</title>
</head>
<body>
    
    <!-- Set variable -->
    <c:set var="userName" value="Aditya das" />

    <!-- Displaying the variable-->
    <p>Hello, <c:out value="${userName}" />!</p>

    <!-- c:if -->
    <c:if test="${userName == 'John Doe'}">
        <p>Welcome back, ${userName}!</p>
    </c:if>

    <!-- Creating list in Java foreach tag -->
    <% 
    ArrayList<String> fruits = new ArrayList<>();
    fruits.add("Apple");
    fruits.add("Banana");
    fruits.add("Cherry");
    request.setAttribute("fruitsList", fruits); // Set the attribute in request scope
    %>

    <!-- c:forEach to loop through the list -->
    <h3>Fruit List:</h3>
    <ul>
        <c:forEach var="fruit" items="${fruitsList}"> <!-- Change fruits to fruitsList -->
            <li><c:out value="${fruit}" /></li>
        </c:forEach>
    </ul>

    <!-- Using c:choose, c:when, and c:otherwise for conditional logic -->
    <c:set var="age" value="20" />
    <c:choose>
        <c:when test="${age >= 18}">
            <p>You are eligible to vote.</p>
        </c:when>
        <c:otherwise>
            <p>You are not eligible to vote</p>
        </c:otherwise>
    </c:choose>

</body>
</html>
