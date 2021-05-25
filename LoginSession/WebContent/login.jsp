<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>

<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
	response.setHeader("Pragma", "no-cache");  // HTTP 1.0
	response.setHeader("Expires", "0");  // Proxies
	
	session.removeAttribute("uname");
	session.invalidate();
%>

<form action="Login" method="post">
  <input type="text" name="name" placeholder="User name"><br>
  <input type="password" name="pass" placeholder="Password"><br>
  <input type="submit" value="Login">
</form>
</body>
</html>