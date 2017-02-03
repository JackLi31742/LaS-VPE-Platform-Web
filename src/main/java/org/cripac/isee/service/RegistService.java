package org.cripac.isee.service;

import org.cripac.isee.dao.RegistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistService {
	
	@Autowired
	private RegistDao registDao;
	
	public void insert(String name, String password,int type) {
		registDao.insert(name, password, type);

		
	}
}
