<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.rsv.beans.compte" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<b style="color:green;">
<%
String message = (String) request.getAttribute("message");
if(message != null)
{
   out.print(message);
}

%> </b>

<% 
compte compte = (compte) request.getAttribute("compte");
%>

<table border="1">
<tr>
<td>CNE</td>
<td><%= compte.getCne() %></td>
</tr>
<tr>
<td>Nom</td>
<td><%= compte.getNom() %></td>
</tr>
<tr>
<td>Prenom</td>
<td><%= compte.getPrenom() %></td>
</tr>
</table>




</body>
</html>