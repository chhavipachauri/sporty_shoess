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
public class GYMController {
@Autowired
	GYMDAO dao;
Logger log=Logger.getAnonymousLogger();
@RequestMapping("insertg")
public ModelAndView insert(HttpServletRequest req,HttpServletResponse res) {
	int gid=Integer.parseInt(req.getParameter("gid"));
	String gname=req.getParameter("gname");
	String gprice=req.getParameter("gprice");
	String gsize=req.getParameter("gsize");
	log.info("recieved name and email from front end");
	ModelAndView mv=new ModelAndView();
	log.info("model and view object created");
	GYM s=new GYM();
	s.setGid(gid);
	log.info("pojo object created");
	s.setGname(gname);
	log.info("name is set to the pojo");
	s.setGprice(gprice);
	log.info("email is set to the pojo");
	s.setGsize(gsize);
	GYM sd=dao.insert(s);
	log.info("insert method called successfully");
	if(sd!=null) {
		log.info("sucessful student insertion");
		mv.setViewName("gym.jsp");
	}
	
	return mv;
}
@RequestMapping("updateg")
public ModelAndView update(HttpServletRequest req,HttpServletResponse res) {
	String gname=req.getParameter("gname");
	String gprice=req.getParameter("gprice");
	String gsize=req.getParameter("gsize");
int rid=Integer.parseInt(req.getParameter("gid"));
	log.info("recieved name and email from front end");
	
	ModelAndView mv=new ModelAndView();
	log.info("model and view object created");
	GYM ss=new GYM();
	log.info("pojo object created");
	ss.setGname(gname);
	log.info("name is set to the pojo");
	ss.setGprice(gprice);
	log.info("email is set to the pojo");
	ss.setGsize(gsize);
	ss.setGid(rid);
	GYM sd=dao.update(ss);
	log.info("update method called successfully");
	if(sd!=null) {
		log.info("sucessful student insertion");
		mv.setViewName("gym.jsp");
	}
	
	return mv;
}
@RequestMapping("deleteg")
public ModelAndView delete(HttpServletRequest req,HttpServletResponse res) {
	int id=Integer.parseInt(req.getParameter("gid"));	
	ModelAndView mv=new ModelAndView();
	GYM s=new GYM();
	s.setGid(id);
	String sd=dao.deleteByid(id);
	if(sd!=null) {
		log.info("sucessful student insertion");
		mv.setViewName("gym.jsp");
	}
	return mv;
}

@RequestMapping("getallg")
public ModelAndView getstudents(HttpServletRequest req,HttpServletResponse res) {
	log.info("in get all request");
	ModelAndView mv=new ModelAndView();
	log.info("created mv object");
	List<GYM> list=dao.getall();
	log.info("called getall method");
	mv.setViewName("gymlist.jsp");
	log.info("went to jsp");
	mv.addObject("list",list);
	log.info("sent a list to the jsp");
	return mv;
}


	
}
