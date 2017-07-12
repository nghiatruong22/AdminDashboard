<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Online Shop</title>
</head>
<body>
<h2>Yo</h2>
<form:form method="post" action="addLogin.html">

	<table>
	<tr>
		<td><form:label path="userName">First Name</form:label></td>
		<td><form:input path="userName" /></td> 
	</tr>
	<tr>
		<td><form:label path="password">Last Name</form:label></td>
		<td><form:input path="password" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="Login"/>
		</td>
	</tr>
</table>	
	
</form:form>
</body>
</html>