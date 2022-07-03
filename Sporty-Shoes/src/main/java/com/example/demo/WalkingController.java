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
public class WalkingController {
@Autowired
	WalkingDAO dao;
Logger log=Logger.getAnonymousLogger();
@RequestMapping("insertw")
public ModelAndView insert(HttpServletRequest req,HttpServletResponse res) {
	int wid=Integer.parseInt(req.getParameter("wid"));
	String wname=req.getParameter("wname");
	String wprice=req.getParameter("wprice");
	String wsize=req.getParameter("wsize");
	log.info("recieved name and email from front end");
	ModelAndView mv=new ModelAndView();
	log.info("model and view object created");
	Walking s=new Walking();
	s.setWid(wid);
	log.info("pojo object created");
	s.setWname(wname);
	log.info("name is set to the pojo");
	s.setWprice(wprice);
	log.info("email is set to the pojo");
	s.setWsize(wsize);
	Walking sd=dao.insert(s);
	log.info("insert method called successfully");
	if(sd!=null) {
		log.info("sucessful student insertion");
		mv.setViewName("walking.jsp");
	}
	
	return mv;
}

@RequestMapping("updatew")
public ModelAndView update(HttpServletRequest req,HttpServletResponse res) {
	String wname=req.getParameter("wname");
	String wprice=req.getParameter("wprice");
	String wsize=req.getParameter("wsize");
int wid=Integer.parseInt(req.getParameter("wid"));
	log.info("recieved name and email from front end");
	
	ModelAndView mv=new ModelAndView();
	log.info("model and view object created");
	Walking ss=new Walking();
	log.info("pojo object created");
	ss.setWname(wname);
	log.info("name is set to the pojo");
	ss.setWprice(wprice);
	log.info("email is set to the pojo");
	ss.setWsize(wsize);
	ss.setWid(wid);
	Walking sd=dao.update(ss);
	log.info("update method called successfully");
	if(sd!=null) {
		log.info("sucessful student insertion");
		mv.setViewName("walking.jsp");
	}
	
	return mv;
}
@RequestMapping("deletew")
public ModelAndView delete(HttpServletRequest req,HttpServletResponse res) {
	int id=Integer.parseInt(req.getParameter("wid"));	
	ModelAndView mv=new ModelAndView();
	Walking s=new Walking();
	s.setWid(id);
	String sd=dao.deleteByid(id);
	if(sd!=null) {
		log.info("sucessful student insertion");
		mv.setViewName("walking.jsp");
	}
	return mv;
}

@RequestMapping("getallw")
public ModelAndView getWalking(HttpServletRequest req,HttpServletResponse res) {
	log.info("in get all request");
	ModelAndView mv=new ModelAndView();
	log.info("created mv object");
	List<Walking> list=dao.getall();
	log.info("called getall method");
	mv.setViewName("walkinglist.jsp");
	log.info("went to jsp");
	mv.addObject("list",list);
	log.info("sent a list to the jsp");
	return mv;
}


	
}
