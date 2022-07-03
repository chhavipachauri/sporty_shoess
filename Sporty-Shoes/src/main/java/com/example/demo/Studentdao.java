package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Studentdao {
	@Autowired
	Studentrepo repo;

	public Student findbyuser(String user) {
		return repo.findByuser(user);
	}
	
	
	public Student findbypassword(String password) {
		return repo.findBypassword(password);
	}
	public Student insert(Student s) {
		return repo.save(s);
	}
	public List<Student> getuser(){
		return repo.findAll();
	}
	
}
