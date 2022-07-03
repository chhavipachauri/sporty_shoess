package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GYMDAO {
	@Autowired
	GYMRepo repo;
	//insert a single object
	public GYM insert(GYM s) {
		return repo.save(s);
	}
	
	
	//retrieve all the objects
	public List<GYM> getall(){
		return repo.findAll();
	}
	
	
	//delete
	public String deleteByid(int gid) {
		repo.deleteById(gid);
		return "deleted the id value:"+gid; 
	}
	
	
	//update
	public GYM update(GYM s) {
		GYM ss=repo.findById(s.getGid()).orElse(null);
		ss.setGname(s.getGname());
		ss.setGname(s.getGprice());
		ss.setGname(s.getGsize());
		
		return repo.save(ss);
	}
	
}