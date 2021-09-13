package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet rs) {

		CategoryModel tmp = new CategoryModel();

		try {

			tmp.setId(rs.getLong("id"));

			tmp.setName(rs.getString("name"));

			tmp.setCode(rs.getString("code"));

			return tmp;

		} catch (SQLException e) {

			return null;

		}

	}

}
