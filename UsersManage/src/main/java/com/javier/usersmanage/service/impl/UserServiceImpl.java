package com.javier.usersmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javier.usersmanage.domain.User;
import com.javier.usersmanage.persistence.Dao;
import com.javier.usersmanage.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired 
	  private Dao dao;

	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	@Override
	public User userById(int uid) {
		return dao.userById(uid);
	}

	@Override
	public void insert(User user) {
		dao.insertUser(user);
	}

	@Override
	public void update(User user) {
		dao.updateUser(user);		
	}

	@Override
	public void delete(User user) {
		dao.deleteUser(user);		
	}

}
