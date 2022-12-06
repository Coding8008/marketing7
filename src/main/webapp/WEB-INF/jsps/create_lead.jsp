<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert  Leads</title>
</head>
<body>
	<h1>Create Leads</h1>
	<form action="saveInfo" method="post">
	<pre>
	First Name<input type="text" name="firstName"/>
	Last Name <input type="text" name="lastName"/>
	Email	  <input type="email" name="email"/>
	Mobile	  <input type="number" name="mobile"/>
	</pre>
	<input type="submit" value="save">
	</form>
	
	${msg}
</body>
</html>