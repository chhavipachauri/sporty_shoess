package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Studentrepo extends JpaRepository<Student, String> {

	@Query("select student from Student student where student.suser=?1")
	public Student findByuser(String user);
	
	@Query("select student from Student student where student.spassword=?1")
	public Student findBypassword(String password);
	
}
