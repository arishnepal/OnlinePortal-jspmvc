package com.onp.dao;

import java.sql.PreparedStatement;
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
	
//wow
}
}
