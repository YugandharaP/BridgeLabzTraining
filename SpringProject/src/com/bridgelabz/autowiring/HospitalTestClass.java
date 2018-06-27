package com.bridgelabz.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HospitalTestClass {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("AutoWiring.xml");
		HospitalBean hospital=context.getBean("hospital", HospitalBean.class);
		System.out.println(hospital);
		HospitalBean hospital1=context.getBean("hospital1", HospitalBean.class);
		System.out.println(hospital);
		
		//hospital.reception();
	}
}
