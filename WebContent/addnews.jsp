<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="adminheader.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="NewsController">
<input type="text" name="actionid" value="create" hidden="true"> 
<div>
<label>title:</label>
<textarea rows="1" cols="100" name="title"></textarea>
</div>
<div>
<label>Content:</label>
<textarea rows="20" cols="100" name="content"></textarea>
</div>
<div>
<label>location:</label>
<input type="text" name="location">
</div>
<div>
<label>category:</label>
<input type="text" name="category">
</div>
<div>
<input type="submit" value="save">
</div>
</form>
</body>
</html>