package org.cripac.isee.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RegistDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	Logger log=null;
	public void insert(String name, String password,int type) {
		String sql = "INSERT INTO user(name,password,type)  VALUES   (?,?,?)";
		log.info(sql);
	    jdbcTemplate.update(sql,new Object[]{name,password,type});

		
	}
}
