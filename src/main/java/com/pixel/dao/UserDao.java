package com.pixel.dao;

import java.util.List;

import com.pixel.model.User;

public interface UserDao {

	public int create(User user);
	public void update(User user);
	public User getById(int id);
	public User getByMail(String mail);
	public void delete(int id);
	public List<User> getUsers(String criteria);
	
}
