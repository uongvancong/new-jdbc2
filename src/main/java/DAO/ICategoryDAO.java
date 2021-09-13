package DAO;

import java.util.List;

import model.CategoryModel;

 

public interface ICategoryDAO extends GenericDAO<CategoryModel>{
	List<CategoryModel> findAll(); 
}
