package DAO.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import DAO.INewsDAO;
import mapper.NewsMapper;
import model.CategoryModel;
import model.NewsModel;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {

		String sql = "SELECT * FROM news where categoryid = ?";

		return query(sql, new NewsMapper(), categoryId);

	}

	@Override
	public Long save(NewsModel newsModel) {

		String sql = "INSERT INTO news (title, content, thumbnail, shortdescription, categoryid, createddate, createdby) VALUES(?, ?, ?,?, ?, ?,?)";

		return insert(sql, newsModel.getTitle(), newsModel.getContent(), newsModel.getThumbnail(),
				newsModel.getShortDescription(), newsModel.getCategoryId(), newsModel.getCreatedDate(),
				newsModel.getCreatedBy());
	}

	@Override
	public NewsModel findOne(Long id) {

		String sql = "SELECT * FROM news where id = ?";

		List<NewsModel> list = query(sql, new NewsMapper(), id);

		if (list.isEmpty()) {

			return null;

		}

		return list.get(0);

	}

	@Override
	public void update(NewsModel updateNews) {

		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
		sql.append(" shortdescription = ?, content = ?, categoryid = ?,");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		update(sql.toString(), updateNews.getTitle(), updateNews.getThumbnail(), updateNews.getShortDescription(),
				updateNews.getContent(), updateNews.getCategoryId(), updateNews.getCreatedDate(),
				updateNews.getCreatedBy(), updateNews.getModifiedDate(), updateNews.getModifiedBy(),
				updateNews.getId());

	}

	@Override
	public void delete(long id) {

		String sql = "DELETE FROM news WHERE id = ?";

		update(sql, id);

	}
}
