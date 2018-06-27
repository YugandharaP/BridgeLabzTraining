package com.bridgelabz.springannotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTestClass {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Annotations.xml");
		CarBean car = context.getBean("carBean", CarBean.class);
		car.startCar();
		System.out.println(car);
	}
}
