package com.onp.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.onp.dto.NewsDto;
import com.onp.util.DbUtil;

public class NewsDaoImp implements NewsDao{
PreparedStatement ps;
	public void saveNewsInfo(NewsDto newsDto) {
			String sql="INSERT into news(content,title,category,location,date) VALUES(?,?,?,?,?)";
			try {
				ps=DbUtil.getConnection().prepareStatement(sql);
				ps.setString(1, newsDto.getContent());
				ps.setString(2, newsDto.getTitle());
				ps.setString(3, newsDto.getCategory());
				ps.setString(4,newsDto.getLocation());
				ps.setString(5, newsDto.getDate());
				ps.executeUpdate();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	}


	public void updateNewsInfo(NewsDto newsDto) {
		String sql="UPDATE news SET content=?,title=?,category=?,location=?,image_url=? WHERE id=?";
		try {
			ps=DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, newsDto.getContent());
			ps.setString(2, newsDto.getTitle());
			ps.setString(4, newsDto.getCategory());
			ps.setString(4,newsDto.getLocation());
			ps.setString(5, newsDto.getImageUrl());
			ps.setInt(6, newsDto.getId());
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}


	public List<NewsDto> getAllNewsInfo() {
		List <NewsDto> newsList=new ArrayList<>();
	String sql="SELECT * from news";
	try {
		ps=DbUtil.getConnection().prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			NewsDto newsDto=new NewsDto();
			newsDto.setId(rs.getInt("id"));
			newsDto.setDate(rs.getString("date"));
			newsDto.setCategory(rs.getString("content"));
			newsDto.setTitle(rs.getString("title"));
			newsDto.setCategory(rs.getString("category"));
			newsDto.setLocation(rs.getString("location"));
			newsDto.setImageUrl(rs.getString("image_url"));
			newsList.add(newsDto);
		}
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	
	return newsList;
	}

	public void deleteNewsInfo(int id) {
				
	}

	public NewsDto getNewsInfoByid(int id) {
		return null;
	}

}
