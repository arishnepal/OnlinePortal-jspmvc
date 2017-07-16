<%@page import="com.onp.service.NewsService"%>
<%@page import="com.onp.service.NewsServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% 
int  id=Integer.parseInt(request.getParameter("id"));
NewsService newsService=new NewsServiceImpl();
request.setAttribute("news", newsService.getNewsInfoByid(id));
;

%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="NewsController">
<div>
<input type="text" name="actionid" value="update" hidden="true"> 
<input type="text" name="newsid" value="${news.id}" hidden="true">
<label>title:</label>
<textarea rows="1" cols="100" name="title" >${news.title}</textarea>
</div>
<div>
<label>Content:</label>
<textarea rows="20" cols="100" name="content">${news.content}</textarea>
</div>
<div>
<label>location:</label>
<input type="text" name="location" value="${news.location}">
</div>
<div>
<label>category:</label>
<input type="text" name="category" value="${news.category}">
</div>
<div>
<input type="submit" value="save">
</div>
</form>
</body>
</html>