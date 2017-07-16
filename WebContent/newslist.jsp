<%@page import="com.onp.service.NewsService"%>
<%@page import="com.onp.service.NewsServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Insert title here</title>
<%
NewsService newsService= new NewsServiceImpl();
request.setAttribute("newss",newsService.getAllNewsInfo()); %>
</head>
<body>
<h1>news list</h1>
<table>
<thead>
<a href="addnews.jsp">Add</a>
<tr>
<th>id</th>
<th>title</th>
<th>location</th>
<th>category</th>
<th>date</th>
<th>actions<th>
</tr>
</thead>
<tbody>
<c:forEach items="${newss}" var="news">
<tr>
<td><c:out value="${news.id}"/></td>
<td><c:out value="${news.title}"/></td>
<td><c:out value="${news.location}"/></td>
<td><c:out value="${news.category}"/></td>
<td><c:out value="${news.date}"/></td>
<td><a href="NewsController?id=${news.id }&action=edit">Edit</a> <a href="NewsController?id=${news.id }&action=delete">Delete</a></td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>