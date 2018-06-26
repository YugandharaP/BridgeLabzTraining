package com.bridgelabz.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bridgelabz.model.Mobile;

public class DependancyInjection {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("DependancyInjection.xml");
		Mobile mobile = (Mobile) context.getBean("mobile");
		mobile.makeCall();
	}
}
