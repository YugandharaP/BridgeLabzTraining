package com.bridgelabz.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**Class-Level Annotation
 * @Retention is define the annotation scope.A retention policy determines at what point annotation should be discarded.
 * Annotation with retention policy SOURCE will be retained only with source code, and discarded during compile time.
 * Annotation with retention policy CLASS will be retained till compiling the code, and discarded during runtime.
 * Annotation with retention policy RUNTIME will be available to the JVM through runtime.
 * @interface used to create custom annotation.
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@interface BridgeLabz {
	String name();
	int empSize();
	
}

/**
 * class level annotation
 */
@BridgeLabz(name = "BridgeLabz", empSize = 20)
class Employee {
	public boolean isEmployee() {
		return false;
	}
}

/**
 * @author yuga
 * purpose-To create custom annotation.
 *
 */
@BridgeLabz(name = "BridgeLabz", empSize = 20)
public class CustomAnnotations {
	public static void main(String[] args) {
		Employee emp = new Employee();//object create
		Class cls = emp.getClass();//Class is built in class which having getClass method which fetch data of employee and store into Class
		Annotation annotation = cls.getAnnotation(BridgeLabz.class);//Annotation is an interface and getAnnotation is a nmethod which fetch all data of Class and store into Annotation type object
		BridgeLabz br = (BridgeLabz) annotation; //to downcast the object into annotation to get perticular element
		System.out.println(br.name() + " " + br.empSize());
	}

}
