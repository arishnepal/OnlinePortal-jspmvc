package com.onp.dao;

import java.util.List;

import com.onp.dto.AdminDto;
import com.onp.dto.NewsDto;

public interface AdminDao {
	public void updateAdminInfo(AdminDto adminDto);
	public AdminDto getAdminByUsernameAndPassword(String username,String password);
}
