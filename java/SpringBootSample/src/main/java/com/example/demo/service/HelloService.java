package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.UserRepository;
import com.example.demo.repository.entity.User;

@Service
@Transactional
public class HelloService {

	@Autowired
	private UserRepository helloRepository;
	
	public void register(String name) {
		User hello = new User();
		hello.setName(name);
		helloRepository.save(hello);
	}
	
	public List<User> findAll() {
		return helloRepository.findAll();
	}
}
