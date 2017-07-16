package com.onp.service;

import java.util.List;

import com.onp.dao.NewsDao;
import com.onp.dao.NewsDaoImp;
import com.onp.dto.NewsDto;

public class NewsServiceImpl implements NewsService{
NewsDao newsDao=new NewsDaoImp();

	public void saveNewsInfo(NewsDto newsDto) {
	newsDao.saveNewsInfo(newsDto);
	}

	@Override
	public void updateNewsInfo(NewsDto newsDto) {
		
		
	}


	public List<NewsDto> getAllNewsInfo() {
	return	newsDao.getAllNewsInfo();
	}


	public void deleteNewsInfo(int id) {
	
	}

	public NewsDto getNewsInfoByid(int id) {

		return null;
	}

}
