package com.javier.usersmanage.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javier.usersmanage.domain.User;

@Repository
@SuppressWarnings({ "unchecked", "rawtypes" })
public class Dao {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<User> findAll() {
		
		Session session = sessionFactory.getCurrentSession();
		List users = (List<User>) session.createQuery("from User").list();
		return users;
	}
	
	@Transactional
	public User userById(int uid) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.createQuery("from User where id = :id").setParameter("id", uid).uniqueResult();
		return user;
	}
	
	@Transactional
	public void insertUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}
	
	@Transactional
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}
	
	@Transactional
	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}
}