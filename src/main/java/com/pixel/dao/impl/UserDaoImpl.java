package com.pixel.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pixel.dao.UserDao;
import com.pixel.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory session;
	
	@Override
	public int create(User user) {
		return (int) session.getCurrentSession().save(user);
	}

	@Override
	public void update(User user) {
		session.getCurrentSession().update(user);
	}

	@Override
	public User getById(int id) {
		return (User) session.getCurrentSession().get(User.class, id);
	}

	@Override
	public User getByMail(String mail) {
		return (User) session.getCurrentSession().get(User.class, mail);
	}

	@Override
	public void delete(int id) {
		User user = getById(id);
		if ( user != null)
			session.getCurrentSession().delete(user);
	}

	@Override
	public List<User> getUsers(String criteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
