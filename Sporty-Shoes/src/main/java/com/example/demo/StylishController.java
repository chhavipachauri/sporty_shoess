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
public class StylishController {
@Autowired
	StylishDAO dao;
Logger log=Logger.getAnonymousLogger();
@RequestMapping("inserts")
public ModelAndView insert(HttpServletRequest req,HttpServletResponse res) {
	int sid=Integer.parseInt(req.getParameter("sid"));
	String sname=req.getParameter("sname");
	String sprice=req.getParameter("sprice");
	String ssize=req.getParameter("ssize");
	log.info("recieved name and email from front end");
	ModelAndView mv=new ModelAndView();
	log.info("model and view object created");
	Stylish s=new Stylish();
	s.setSid(sid);
	log.info("pojo object created");
	s.setSname(sname);
	log.info("name is set to the pojo");
	s.setSprice(sprice);
	log.info("email is set to the pojo");
	s.setSsize(ssize);
	Stylish sd=dao.insert(s);
	log.info("insert method called successfully");
	if(sd!=null) {
		log.info("sucessful student insertion");
		mv.setViewName("stylish.jsp");
	}
	
	return mv;
}

@RequestMapping("updates")
public ModelAndView update(HttpServletRequest req,HttpServletResponse res) {
	String sname=req.getParameter("sname");
	String sprice=req.getParameter("sprice");
	String ssize=req.getParameter("ssize");
int sid=Integer.parseInt(req.getParameter("sid"));
	log.info("recieved name and email from front end");
	
	ModelAndView mv=new ModelAndView();
	log.info("model and view object created");
	Stylish ss=new Stylish();
	log.info("pojo object created");
	ss.setSname(sname);
	log.info("name is set to the pojo");
	ss.setSprice(sprice);
	log.info("email is set to the pojo");
	ss.setSsize(ssize);
	ss.setSid(sid);
	Stylish sd=dao.update(ss);
	log.info("update method called successfully");
	if(sd!=null) {
		log.info("sucessful student insertion");
		mv.setViewName("stylish.jsp");
	}
	
	return mv;
}
@RequestMapping("deletes")
public ModelAndView delete(HttpServletRequest req,HttpServletResponse res) {
	int sid=Integer.parseInt(req.getParameter("sid"));	
	ModelAndView mv=new ModelAndView();
	Stylish s=new Stylish();
	s.setSid(sid);
	String sd=dao.deleteByid(sid);
	if(sd!=null) {
		log.info("sucessful student insertion");
		mv.setViewName("stylish.jsp");
	}
	return mv;
}

@RequestMapping("getalls")
public ModelAndView getStylish(HttpServletRequest req,HttpServletResponse res) {
	log.info("in get all request");
	ModelAndView mv=new ModelAndView();
	log.info("created mv object");
	List<Stylish> list=dao.getall();
	log.info("called getall method");
	mv.setViewName("stylishlist.jsp");
	log.info("went to jsp");
	mv.addObject("list",list);
	log.info("sent a list to the jsp");
	return mv;
}


	
}

