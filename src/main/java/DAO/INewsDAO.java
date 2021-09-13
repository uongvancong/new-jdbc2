package DAO;

import java.util.List;

import model.NewsModel;

public interface INewsDAO extends GenericDAO<NewsModel>{
	
	NewsModel findOne(Long id);
	
	List<NewsModel> findByCategoryId(Long categoryId);
	
	Long save(NewsModel newsModel);
	
	void update(NewsModel updateNews);
	
	void delete(long id);
	
}
