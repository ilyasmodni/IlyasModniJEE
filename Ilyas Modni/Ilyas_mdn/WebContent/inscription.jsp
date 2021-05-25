<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Formulaire d'Inscription</h1>
<form action="compte" method="post">
<table>
<tr>
<td>Nom :</td>
<td><input type="text" name="nom" /></td>
</tr>
<tr>
<td>Prenom :</td>
<td><input type="text" name="prenom" /></td>
</tr>
<tr>
<td>CNE :</td>
<td><input type="text" name="cne" /></td>
</tr>
<tr>
<td></td>
<td><input type="submit" name="submit" value="Envoyer"/></td>
</tr>
</table>
</form>
<br />
<b style="color:red;">
<%
String message = (String) request.getAttribute("message");
if(message != null)
{
   out.print(message);
}
%> </b>
</div>
</body>
</html>