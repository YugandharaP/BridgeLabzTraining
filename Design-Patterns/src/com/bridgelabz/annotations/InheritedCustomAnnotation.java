package com.bridgelabz.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@interface ForEveryOne {
	int value() default 10;
}


class SuperClass {
	@ForEveryOne(value= 20)
	public void superMethod() {
		System.out.println("SuperCLass Method");
	}
}

class childClass extends SuperClass{
	public void childMethod() {
		System.out.println("ChildCLass Method");
	}
}

public class InheritedCustomAnnotation  {

	public static void main(String[] args) {
		childClass inherited =new childClass();
		try {
			Method method= inherited.getClass().getMethod("super Method");
			Annotation annotation = method.getAnnotation(ForEveryOne.class);
			ForEveryOne every=(ForEveryOne) annotation;
			inherited.childMethod();
			System.out.println(every.value());
			
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
	}
}
