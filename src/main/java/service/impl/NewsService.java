package service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import DAO.INewsDAO;
import model.NewsModel;
import service.INewsService;

public class NewsService implements INewsService {

	@Inject
	private INewsDAO newsDAO;

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {

		return newsDAO.findByCategoryId(categoryId);
	}

	@Override
	public NewsModel save(NewsModel news) {

		news.setCreatedDate(new Timestamp(System.currentTimeMillis()));

		news.setCreatedBy("");

		Long newsId = newsDAO.save(news);

		return newsDAO.findOne(newsId);
	}

	@Override
	public NewsModel update(NewsModel updateNews) {

		NewsModel oldNew = newsDAO.findOne(updateNews.getId());
		
		updateNews.setCreatedDate(oldNew.getCreatedDate());
		
		updateNews.setCreatedBy(oldNew.getCreatedBy());
		
		updateNews.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		
		updateNews.setModifiedBy("");
		
		newsDAO.update(updateNews);

		return newsDAO.findOne(updateNews.getId());

	}

	@Override
	public void delete(long[] ids) {

		for (long id : ids) {

			newsDAO.delete(id);

		}

	}

}
