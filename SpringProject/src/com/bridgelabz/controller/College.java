package com.bridgelabz.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.bridgelabz.model.StudentBean;

public class College {

	public static void main(String[] args) {
		
		//Resource resource = new ClassPathResource("BeanLifeCycle");
		ApplicationContext context = new ClassPathXmlApplicationContext("BeanLifeCycle.xml");
		StudentBean student=(StudentBean) context.getBean("student");
		System.out.println(student);
		ClassPathXmlApplicationContext ctx =(ClassPathXmlApplicationContext) context;
		ctx.close();
	}

}
