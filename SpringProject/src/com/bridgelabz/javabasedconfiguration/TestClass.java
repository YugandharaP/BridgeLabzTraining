package com.bridgelabz.javabasedconfiguration;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TestClass {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationClass.class);
		Computer computer = context.getBean(Computer.class);
		/*Resource res=new ClassPathResource("ConfigurationClass.class");
		BeanFactory fact=new XmlBeanFactory(res);
		Computer computer=fact.getBean(Computer.class);*/
		computer.turnOn();
		System.out.println("Computer turn on\n");
		computer.turnOff();
		System.out.println("Computer turn off");
	}
}
