package com.pixel.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pixel.model.User;
import com.pixel.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService ss;

	private String criterion = "t";

	public UserController() {
	}

	@RequestMapping("/index")
	public String setupForm(Map<String, Object> map) {
		User user = new User();

		map.put("user", user);
		map.put("userList", ss.getUsers(criterion));

		return "User";
	}

	@RequestMapping(value = "/user.do", method = RequestMethod.POST)
	public String doActions(@ModelAttribute User user, BindingResult result, @RequestParam String action,
			Map<String, Object> map, String criterion) {
		User userResult = new User();
		List<User> list = new ArrayList<>();

		switch (action.toLowerCase()) {
		case "create":
			ss.create(user);
			userResult = user;
			break;
		case "update":
			ss.update(user);
			userResult = user;
			break;
		case "getbyid":
			User u = ss.getById(user.getId());
			userResult = u != null ? u : new User();
			break;
		case "getbymail":
			User us = ss.getByMail(user.getEmail());
			userResult = us != null ? us : new User();
			break;
		case "delete":
			ss.delete(user.getId());
			userResult = new User();
			break;
		case "getusers":
			list = ss.getUsers(user.getEmail());
			System.out.println(list.size());
			break;
		default:
			break;
		}
		map.put("user", userResult);
		map.put("userList", list);
		return "User";
	}

}
