package DAO.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import DAO.GenericDAO;
import mapper.RowMapper;
import java.sql.Timestamp;
import java.sql.Types;

public class AbstractDAO<T> implements GenericDAO<T> {
	public Connection getConnection() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/newservlet";
			String user = "root";
			String password = "72093711124";

			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;

		}

	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {

		List<T> results = new ArrayList<>();

		Connection connection = null;

		PreparedStatement statement = null;

		ResultSet resultset = null;

		try {

			connection = getConnection();

			statement = connection.prepareStatement(sql);

			setParemeter(statement, parameters);

			resultset = statement.executeQuery();

			while (resultset.next()) {

				results.add(rowMapper.mapRow(resultset));

			}

			return results;

		} catch (SQLException e) {

			return null;

		} finally {

			try {
				if (connection != null) {

					connection.close();

				}

				if (statement != null) {

					statement.close();

				}

				if (resultset != null) {

					resultset.close();

				}

			} catch (SQLException e) {

				return null;

			}

		}

	}

	private void setParemeter(PreparedStatement statement, Object... parameters) {

		for (int i = 0; i < parameters.length; ++i) {

			Object parameter = parameters[i];

			int index = i + 1;

			try {
				if (parameter instanceof Long) {

					statement.setLong(index, (Long) parameter);

				} else if (parameter instanceof String) {

					statement.setString(index, (String) parameter);

				} else if (parameter instanceof Integer) {

					statement.setInt(index, (Integer) parameter);

				} else if (parameter instanceof Timestamp) {

					statement.setTimestamp(index, (Timestamp) parameter);

				} else if (parameter == null) {

					statement.setNull(index, Types.NULL);

				}

			} catch (SQLException e) {

				e.printStackTrace();

			}

		}

	}

	@Override
	public void update(String sql, Object... parameters) {

		Connection connection = null;

		PreparedStatement statement = null;

		try {
			connection = getConnection();

			connection.setAutoCommit(false);

			statement = connection.prepareStatement(sql);

			setParemeter(statement, parameters);

			statement.executeUpdate();

			connection.commit();

		} catch (SQLException e) {

			if (connection != null) {

				try {

					connection.rollback();

				} catch (SQLException e1) {

					e1.printStackTrace();

				}

			}

		} finally {

			try {
				if (connection != null) {

					connection.close();

				}

				if (statement != null) {

					statement.close();

				}

			} catch (SQLException e) {

				e.printStackTrace();

			}

		}

	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Connection connection = null;

		PreparedStatement statement = null;

		ResultSet resultSet = null;

		Long id = null;

		try {
			connection = getConnection();

			connection.setAutoCommit(false);

			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			setParemeter(statement, parameters);

			statement.executeUpdate();

			resultSet = statement.getGeneratedKeys();

			if (resultSet.next()) {

				id = resultSet.getLong(1);

			}

			connection.commit();

			return id;

		} catch (SQLException e) {

			if (connection != null) {

				try {

					connection.rollback();

				} catch (SQLException e1) {

					e1.printStackTrace();

				}

			}

		} finally {

			try {

				if (connection != null) {

					connection.close();

				}

				if (statement != null) {

					statement.close();

				}

				if (resultSet != null) {

					resultSet.close();

				}

			} catch (SQLException e) {

				return null;

			}

		}

		return null;
	}

}
