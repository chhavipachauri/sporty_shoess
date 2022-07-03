package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class WalkingDAO {
	@Autowired
	WalkingRepo repo;
	//insert a single object
	public Walking insert(Walking s) {
		return repo.save(s);
	}
	
	
	//retrieve all the objects
	public List<Walking> getall(){
		return repo.findAll();
	}
	
	
	//delete
	public String deleteByid(int id) {
		repo.deleteById(id);
		return "deleted the id value:"+id; 
	}
	
	
	//update
	                     //updated value: 1 pavan k@c.c
	public Walking update(Walking s) {
		Walking ss=repo.findById(s.getWid()).orElse(null);
		ss.setWname(s.getWname());
		ss.setWprice(s.getWprice());
		ss.setWsize(s.getWsize());
		
		return repo.save(ss);
	}
	
}