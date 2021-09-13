package service.impl;

import java.util.List;

import javax.inject.Inject;

import DAO.ICategoryDAO;
import DAO.impl.CategoryDAO;
import model.CategoryModel;
import service.ICategoryService;

public class CategoryService implements ICategoryService{

	@Inject
	private ICategoryDAO categoryDAO;
	
 
	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
