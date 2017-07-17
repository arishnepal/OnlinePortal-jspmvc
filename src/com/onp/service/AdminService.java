package com.onp.service;

import com.onp.dto.AdminDto;
import com.onp.dto.NewsDto;

public interface AdminService {
	public void updateAdminInfo(NewsDto newsDto);
	public AdminDto getAdminByUsernameAndPassword(String username,String password);
}
