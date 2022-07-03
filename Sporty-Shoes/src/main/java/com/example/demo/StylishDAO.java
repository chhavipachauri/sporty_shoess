package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StylishDAO {
	@Autowired
	StylishRepo repo;
	//insert a single object
	public Stylish insert(Stylish s) {
		return repo.save(s);
	}
	
	
	//retrieve all the objects
	public List<Stylish> getall(){
		return repo.findAll();
	}
	
	
	//delete
	public String deleteByid(int sid) {
		repo.deleteById(sid);
		return "deleted the id value:"+sid; 
	}
	
	
	//update
	                     //updated value: 1 pavan k@c.c
	public Stylish update(Stylish s) {
		Stylish ss=repo.findById(s.getSid()).orElse(null);
		ss.setSname(s.getSname());
		ss.setSname(s.getSprice());
		ss.setSname(s.getSsize());
		
		return repo.save(ss);
	}
	
}