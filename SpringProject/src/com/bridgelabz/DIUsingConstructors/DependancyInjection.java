package com.bridgelabz.DIUsingConstructors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DependancyInjection {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("DependancyInjection.xml");
		MobileBean mobile = (MobileBean) context.getBean("mobile");
		mobile.makeCall();
	}
}
