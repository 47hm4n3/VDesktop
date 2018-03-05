package com.pixel.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pixel.dao.UserDao;
import com.pixel.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory session;
	
	public UserDaoImpl() {}
	
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
		return (User) session.getCurrentSession().createQuery("FROM User u where u.email like '" + mail + "'").list().get(0);
	}

	@Override
	public void delete(int id) {
		User user = getById(id);
		if ( user != null)
			session.getCurrentSession().delete(user);
	}

	@Override
	public List<User> getUsers(String criterion) {
		System.out.println(criterion);
		// return (List<User>)session.getCurrentSession().createQuery("SELECT ALL FROM Useer WHERE name='" + criteria + "' OR lastname='" + criteria + "' OR email='" + criteria + "'").list();
		return (List<User>)session.getCurrentSession().createQuery("FROM User u WHERE u.name like '%" + criterion + "%' OR u.lastName like '%" + criterion + "%' OR u.email like '%" + criterion + "%'").list();
	}

}
