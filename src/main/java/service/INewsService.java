package service;

import java.util.List;

import model.NewsModel;

public interface INewsService {

	List<NewsModel> findByCategoryId(Long categoryId);

	NewsModel save(NewsModel news);

	NewsModel update(NewsModel updateNews);
	
	void delete(long[] ids);
	
}
