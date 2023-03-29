<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>page</title>
</head>
<body>
<form action="login15" method="post">
<h2>Login here.....</h2>
<hr>
<table>
<tr>
<td>Email</td>
<td><input type="text" name="email"></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td><input type="submit" value="login"></td>
</tr>

</table>


</form>
<%
if(request.getAttribute("error")!=null){
	out.println(request.getAttribute("error"));
}
%>

</body>
</html>