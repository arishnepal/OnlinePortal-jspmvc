package com.onp.dao;

import java.util.List;

import com.onp.dto.NewsDto;

public interface NewsDao {
	public void saveNewsInfo(NewsDto newsDto);
	public void updateNewsInfo(NewsDto newsDto);
	public List<NewsDto> getAllNewsInfo();
	public void deleteNewsInfo(int id);
	public NewsDto getNewsInfoByid(int id);

}
