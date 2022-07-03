package com.example.demo;


	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
	@Data
	@Entity
	public class GYM {
		@Id
		//@GeneratedValue(strategy = GenerationType.AUTO)
//		@GeneratedValue(generator="system-uuid")
//		   @GenericGenerator(name="system-uuid", strategy = "uuid")
		private int gid;
		private String gname;
		private String gprice;
		private String gsize;
}