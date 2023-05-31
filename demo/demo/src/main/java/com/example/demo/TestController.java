package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestController {
	@RequestMapping("/abc")
	public String test(Model model) {
		User user1 = new User("kim","seoul","a@a.com");
		User user2 = new User("lee","busan","a@a.com");
		User user3 = new User("park","seoul","a@a.com");
	
	List<User>list = new ArrayList<User>();
	list.add(user1);
	list.add(user2);
	list.add(user3);
	model.addAttribute("list", list);
	return "test";
		}
}
