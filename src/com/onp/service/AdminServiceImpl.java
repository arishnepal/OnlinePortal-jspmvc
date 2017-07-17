package com.onp.service;

import com.onp.dao.AdminDao;
import com.onp.dao.AdminDaoImpl;
import com.onp.dto.AdminDto;
import com.onp.dto.NewsDto;

public class AdminServiceImpl implements AdminService{
AdminDao adminDao= new AdminDaoImpl();
	public void updateAdminInfo(NewsDto newsDto) {
	
		
	}

	
	public AdminDto getAdminByUsernameAndPassword(String username, String password) {
		return adminDao.getAdminByUsernameAndPassword(username, password);
	}

}
