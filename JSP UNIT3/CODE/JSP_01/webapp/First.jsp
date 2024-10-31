<!-- Page directives -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>

<html>
<head>
<title>First JSP program</title>
</head>
<body>

<!-- Include page directives -->
<%@ include file="header.jsp" %>

<!-- Scriplet -->
<% int number = 10; %>
<% Date date= new Date(); %>

<!-- Declarations  -->
<%!  int Square(int number) { 
				return number * number;
				 } %>

<!-- Expression -->
<p>The square of <%= number %> is: <%= Square(number) %></p>
 <p>The sum of 5+5 is <%= 5+5 %></p>
<p>current date is <%=date%></p>

<!-- HTML COMMENT --> 
<%--JSP COMMMENT --%>
<%--include directives --%>
<%@ include file="footer.jsp" %>

</body>
</html>

