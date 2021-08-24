package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.repository.entity.User;
import com.example.demo.service.HelloService;

@RequestMapping("/hello")
@Controller
public class HelloController {

	@Autowired
	private HelloService helloService;
	
	@GetMapping
	public ModelAndView init(ModelAndView modelAndView) {
		List<User> userList = helloService.findAll();
		modelAndView.addObject("userList", userList);
		modelAndView.addObject("form", new HelloForm());
		modelAndView.setViewName("hello");
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView register(@ModelAttribute HelloForm form, ModelAndView modelAndView) {
		helloService.register(form.getName());
		
		List<User> userList = helloService.findAll();
		modelAndView.addObject("userList", userList);
		modelAndView.addObject("form", form);
		modelAndView.setViewName("hello");
		return modelAndView;
	}
}
