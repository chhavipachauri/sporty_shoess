package com.example.demo;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RunningController {
@Autowired
	RunningDAO dao;
Logger log=Logger.getAnonymousLogger();
@RequestMapping("insertr")
public ModelAndView insert(HttpServletRequest req,HttpServletResponse res) {
	int rid=Integer.parseInt(req.getParameter("rid"));
	String rname=req.getParameter("rname");
	String rprice=req.getParameter("rprice");
	String rsize=req.getParameter("rsize");
	log.info("recieved name and email from front end");
	ModelAndView mv=new ModelAndView();
	log.info("model and view object created");
	RunningShoes s=new RunningShoes();
	s.setId(rid);
	log.info("pojo object created");
	s.setRname(rname);
	log.info("name is set to the pojo");
	s.setRprice(rprice);
	log.info("email is set to the pojo");
	s.setRsize(rsize);
	RunningShoes sd=dao.insert(s);
	log.info("insert method called successfully");
	if(sd!=null) {
		log.info("sucessful student insertion");
		mv.setViewName("running.jsp");
	}
	
	return mv;
}
@RequestMapping("updater")
public ModelAndView update(HttpServletRequest req,HttpServletResponse res) {
	String name=req.getParameter("rname");
	String price=req.getParameter("rprice");
	String size=req.getParameter("rsize");
int rid=Integer.parseInt(req.getParameter("rid"));
	log.info("recieved name and email from front end");
	
	ModelAndView mv=new ModelAndView();
	log.info("model and view object created");
	RunningShoes ss=new RunningShoes();
	log.info("pojo object created");
	ss.setRname(name);
	log.info("name is set to the pojo");
	ss.setRprice(price);
	log.info("email is set to the pojo");
	ss.setRsize(size);
	ss.setId(rid);
	RunningShoes sd=dao.update(ss);
	log.info("update method called successfully");
	if(sd!=null) {
		log.info("sucessful student insertion");
		mv.setViewName("status.jsp");
	}
	
	return mv;
}
@RequestMapping("deleter")
public ModelAndView delete(HttpServletRequest req,HttpServletResponse res) {
	int id=Integer.parseInt(req.getParameter("rid"));	
	ModelAndView mv=new ModelAndView();
	RunningShoes s=new RunningShoes();
	s.setId(id);
	String sd=dao.deleteByid(id);
	if(sd!=null) {
		log.info("sucessful student insertion");
		mv.setViewName("status.jsp");
	}
	return mv;
}

@RequestMapping("getallr")
public ModelAndView getstudents(HttpServletRequest req,HttpServletResponse res) {
	log.info("in get all request");
	ModelAndView mv=new ModelAndView();
	log.info("created mv object");
	List<RunningShoes> list=dao.getall();
	log.info("called getall method");
	mv.setViewName("runninglist.jsp");
	log.info("went to jsp");
	mv.addObject("list",list);
	log.info("sent a list to the jsp");
	return mv;
}


	
}
