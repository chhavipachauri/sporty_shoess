package com.example.demo;


	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
	@Data
	@Entity
	public class RunningShoes {
		@Id
		//@GeneratedValue(strategy = GenerationType.AUTO)
//		@GeneratedValue(generator="system-uuid")
//		   @GenericGenerator(name="system-uuid", strategy = "uuid")
		private int id;
		private String rname;
		private String rprice;
		private String rsize;
}
