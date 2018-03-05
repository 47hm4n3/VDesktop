package com.pixel.service.mpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pixel.dao.UserDao;
import com.pixel.model.User;
import com.pixel.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao udao;

	public UserServiceImpl() {}
	
	@Transactional
	public int create(User user) {
		return udao.create(user);
	}

	@Transactional
	public void update(User user) {
		udao.update(user);
	}

	@Transactional
	public User getById(int id) {
		return udao.getById(id);
	}

	@Transactional
	public User getByMail(String mail) {
		return udao.getByMail(mail);
	}

	@Transactional
	public void delete(int id) {
		udao.delete(id);
	}

	@Transactional
	public List<User> getUsers(String criterion) {
		return udao.getUsers(criterion);
	}

}
