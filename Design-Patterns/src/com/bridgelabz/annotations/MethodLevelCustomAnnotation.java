package com.bridgelabz.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Car{
	String carName();
	long price() default 100000;
	// public boolean enabled() default true;
}


class MyCar{
	@Car(carName= "Toyota")
	public void myCar() {
		System.out.println("This is my car");
	}
}

public class MethodLevelCustomAnnotation {

	public static void main(String[] args) throws Exception {
		MyCar car=new MyCar();
		Method method=car.getClass().getMethod("myCar");
		Annotation myannotation=method.getAnnotation(Car.class);
		Car car1=(Car) myannotation;
		car.myCar();
		System.out.println("car name: "+car1.carName()+" and price is: "+car1.price());
	}
}
