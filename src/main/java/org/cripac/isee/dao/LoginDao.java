package org.cripac.isee.dao;

import org.cripac.isee.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public User getUser(String name, String password) {
		String sql = "SELECT * FROM user WHERE name = ? and password=?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		User user = jdbcTemplate.queryForObject(sql, rowMapper, name, password);

		if (user != null) {

			return user;
		}
		return null;
	}
}
