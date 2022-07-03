package com.example.demo;


	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
	@Data
	@Entity
	public class Walking {
		@Id
		private int wid;
		private String wname;
		private String wprice;
		private String wsize;
		}