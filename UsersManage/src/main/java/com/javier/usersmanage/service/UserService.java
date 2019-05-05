package com.javier.usersmanage.service;

import java.util.List;

import com.javier.usersmanage.domain.User;

public interface UserService {
	  
	  public List<User> findAll();
	  
	  public User userById(int uid);
	  
	  public void insert(User user);
	  
	  public void update(User user);
	  
	  public void delete(User user);

}
