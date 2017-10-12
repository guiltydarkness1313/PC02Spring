<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<form:form method="POST" action="/pc02tecsup/lista">
            <input type="submit" value="show"/>
</form:form>
</body>
</html>
