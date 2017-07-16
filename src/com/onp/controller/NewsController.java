package com.onp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onp.dao.NewsDao;
import com.onp.dto.NewsDto;
import com.onp.service.NewsService;
import com.onp.service.NewsServiceImpl;

@WebServlet("/NewsController")
public class NewsController extends HttpServlet {
	NewsService newsService=new NewsServiceImpl();
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
		int id=Integer.parseInt(request.getParameter("id"));
		String action=request.getParameter("action");
		if(!action.isEmpty()&&action.equals("edit")) {
			forward="editnews.jsp";
		}
		if(!action.isEmpty()&&action.equals("delete")) {
			newsService.deleteNewsInfo(id);
			forward="newslist.jsp";
		}
		RequestDispatcher rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsDto newsDto=new NewsDto();
		String content=request.getParameter("content");
		String title=request.getParameter("title");
		String location=request.getParameter("location");
		String category=request.getParameter("category");
		
		Timestamp timestamp=new Timestamp(System.currentTimeMillis());
		String time=String.valueOf(timestamp);
		newsDto.setDate(time);
		newsDto.setContent(content);
		newsDto.setCategory(category);
		newsDto.setTitle(title);
		newsDto.setLocation(location);
		
		String id=request.getParameter("actionid");
		if(id.equals("create")) {
			newsService.saveNewsInfo(newsDto);
		}
		else {
			int newsid=Integer.parseInt(request.getParameter("newsid"));
			newsDto.setId(newsid);
			newsService.updateNewsInfo(newsDto);
		}
		
		response.sendRedirect("newslist.jsp");
		
	}

}
