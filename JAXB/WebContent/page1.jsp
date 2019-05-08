<%@page import="java.util.ArrayList"%>
<%@page import="storage.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
<% 
ArrayList<String> als = (ArrayList<String>)request.getAttribute("als");
User u = (User)request.getAttribute("user");
%>
Welcome <%=u.getUsername()%>! Have a random table: <br>
<table border="1">
<%for ( String s: als ){ %>
	<tr> <td> <%=s%> </td> </tr>
<%}%>
</table>
<button onClick="location.href='Ajax.html'">To AJAX and beyond!</button>
</body>
</html>