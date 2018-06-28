package com.bridgelabz.springannotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTestClass {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Annotations.xml");
		CarBean car = context.getBean("carBean", CarBean.class);
		car.startCar();
		System.out.println("@Scope(value=\"prototype\")used here "+car.hashCode());
		System.out.println();
		CarBean car1 = context.getBean("carBean", CarBean.class);
		car1.startCar();
		System.out.println("@Scope(value=\"prototype\")used here "+car1.hashCode());
	}
}
