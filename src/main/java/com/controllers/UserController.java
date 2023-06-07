package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.UserDao;
import com.models.User;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "/fetchUser", method = RequestMethod.POST)
	public String search(@RequestParam("id") int id, Model model) {
		User user = userDao.searchUserById(id);
		if (user != null) {
            model.addAttribute("user", user);
            return "details";
        }
        else {
        	model.addAttribute("message", "User not found");
        	return home();
        }
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute User user, Model model) {
		userDao.updateUser(user);
		model.addAttribute("success", "User updated successfully....");
		return "details";
	}
}
