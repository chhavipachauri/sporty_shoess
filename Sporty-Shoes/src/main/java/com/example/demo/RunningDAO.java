package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RunningDAO {
	@Autowired
	RunningRepo repo;
	//insert a single object
	public RunningShoes insert(RunningShoes s) {
		return repo.save(s);
	}
	
	
	//retrieve all the objects
	public List<RunningShoes> getall(){
		return repo.findAll();
	}
	
	
	//delete
	public String deleteByid(int id) {
		repo.deleteById(id);
		return "deleted the id value:"+id; 
	}
	
	
	//update
	                     //updated value: 1 pavan k@c.c
	public RunningShoes update(RunningShoes s) {
		RunningShoes ss=repo.findById(s.getId()).orElse(null);
		ss.setRname(s.getRname());
		ss.setRname(s.getRprice());
		ss.setRname(s.getRsize());
		
		return repo.save(ss);
	}
	
}