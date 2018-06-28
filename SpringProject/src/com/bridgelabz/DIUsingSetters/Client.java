package com.bridgelabz.DIUsingSetters;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.bridgelabz.model.Employee;

/**purpose-To create an object of EmployeeBean class with the help of IOC(InnversionOfControl) to achieve loose coupling
 * using Dependency Injection.(Using getters setters we achieve DI)
 * In this program we used (Resource,BeanFactory,ApplicationContext)to inject the bean class.
 * @author yuga
 * @since 26/06/2018
 * 
 *
 */
public class Client {
	public static void main(String[] args) {
		// Object creation || by developer
		// simple java logic to get employee deatils
		Employee emp = new Employee();
		emp.setEid(101);
		emp.setName("Yuga");
		emp.setAddress("Mumbai");
		System.out.println("Employee deatails are here : " + emp);
		// Object creation done || by Spring (Using concept IOC)
		
		
		//FileSystemResource resource=new FileSystemResource("src//SpringConfig.xml");
		Resource resource=new ClassPathResource("SpringConfig.xml");
		BeanFactory factory=new XmlBeanFactory(resource);
		Employee emp1=(Employee) factory.getBean("emp1");
		System.out.println(emp1);
		Employee emp2=(Employee) factory.getBean("emp2",Employee.class);
		System.out.println(emp2);
		
		System.out.println();
		
		ApplicationContext context =new ClassPathXmlApplicationContext("SpringConfig.xml");
		 emp1=(Employee) context.getBean("emp1");
		System.out.println(emp1);
		 emp2=(Employee) context.getBean("emp2",Employee.class);
		System.out.println(emp2);
		
	}
}
