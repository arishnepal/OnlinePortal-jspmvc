package com.onp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onp.dao.AdminDao;
import com.onp.dao.AdminDaoImpl;
import com.onp.dto.AdminDto;
import com.onp.service.AdminService;
import com.onp.service.AdminServiceImpl;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	AdminService adminService;
	
	private static final long serialVersionUID = 1L;
	public LoginController() {
		super();
		adminService= new AdminServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String forward="";
	String username=request.getParameter("username");
	String password=request.getParameter("password");
//	AdminDto adminDto=new AdminDto();
//	adminDto.setUsername("admin");
//	adminDto.setPassword("admin");
	AdminDto adminDto=adminService.getAdminByUsernameAndPassword(username, password);
	System.out.println(adminDto.getUsername());
	System.out.println(adminDto.getPassword());
	if(username.equals(adminDto.getUsername())&& password.equals(adminDto.getPassword())) {
		HttpSession session=request.getSession();
		session.setAttribute("username", username);
		forward="adminpanel.jsp";
	}
	else {
		forward="Login.jsp";
	}
	RequestDispatcher rd=request.getRequestDispatcher(forward);
	rd.forward(request, response);
	}

}
