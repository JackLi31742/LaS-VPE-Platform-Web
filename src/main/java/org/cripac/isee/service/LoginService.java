package org.cripac.isee.service;

import org.cripac.isee.dao.LoginDao;
import org.cripac.isee.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	@Autowired
	private LoginDao loginDao;

	
	public User getUser(String name, String password) {
		
		User user = loginDao.getUser(name, password);

		if (user != null) {

			return user;
		}
		return null;
	}
}
