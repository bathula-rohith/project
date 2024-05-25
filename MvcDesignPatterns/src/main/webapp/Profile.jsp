<%@page import="insp.backend.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

User user =(User) session.getAttribute("details"); 
%>

<h2>Name:<%=user.getName() %></h2>
<%="<br/>" %>
<h2>email:<%=user.getEmail() %></h2>
<%="<br/>" %>
<h2>password:<%=user.getPassword() %></h2>
<%="<br/>" %>
<h2>city:<%=user.getCity() %></h2>
<%="<br/>" %>

<a href ="logout">Logout</a>


</body>
</html>