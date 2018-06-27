package com.bridgelabz.beanscope;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanScopeTestClass {

	public static void main(String[] args) {
		Resource resource= new ClassPathResource("BeanScope.xml");
		BeanFactory factory= new XmlBeanFactory(resource);
		CollegeBean college= factory.getBean("college", CollegeBean.class);
		System.out.println(college.hashCode());
		college.registerStudent();
		college= factory.getBean("college", CollegeBean.class);
		System.out.println(college.hashCode());
		college.registerStudent();
		college= factory.getBean("college", CollegeBean.class);
		System.out.println(college.hashCode());
		college.registerStudent();
	}
}
