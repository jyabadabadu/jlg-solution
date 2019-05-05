package com.javier.usersmanage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javier.usersmanage.domain.User;
import com.javier.usersmanage.service.UserService;


@Controller
@RequestMapping("/")
public class UserController {

	private static int num = 8;

	@Autowired
	private UserService userServiceImpl;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<User> users = userServiceImpl.findAll();
		model.addAttribute("users", users);
		model.addAttribute("user", new User());
		return "index";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("user", new User());
		return "alta";
	}

	@RequestMapping("/addUser")
	public String addUser(@ModelAttribute("user") User user) {
		user.setId(num);
		num++;
		userServiceImpl.insert(user);
		return "redirect:/";
	}
	
	@RequestMapping("/delete")
	public String delete(@ModelAttribute("user") User user) {
		userServiceImpl.delete(user);
		return "redirect:/";
	}
	
	@RequestMapping("/update")
	public String update(Model model, @ModelAttribute("user") User user) {
		model.addAttribute("user", user);
		return "modificar";
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(@ModelAttribute("user") User user) {
		userServiceImpl.update(user);
		return "redirect:/";
	}
	
}
