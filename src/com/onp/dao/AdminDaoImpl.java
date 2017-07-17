package com.onp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.onp.dto.AdminDto;
import com.onp.dto.NewsDto;
import com.onp.util.DbUtil;

public class AdminDaoImpl implements AdminDao {
	PreparedStatement ps;
	public void updateAdminInfo(AdminDto adminDto) {
	String sql="UPDATE admins SET password=? email=? WHERE id=?";
	try {
		ps=DbUtil.getConnection().prepareStatement(sql);
		ps.setString(1,adminDto.getPassword());
		ps.setString(2,adminDto.getEmail() );
		ps.setInt(3, adminDto.getId());
		ps.executeUpdate();
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
}
	
	public AdminDto getAdminByUsernameAndPassword(String username, String password) {
		AdminDto adminDto=new AdminDto();
		String sql="SELECT * FROM admins WHERE username=? AND password=?";
	try {
		ps=DbUtil.getConnection().prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery(); 
		while(rs.next()) {
			adminDto.setUsername(rs.getString("username"));
			adminDto.setPassword(rs.getString("password"));
		}
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	return adminDto;
	}
}
