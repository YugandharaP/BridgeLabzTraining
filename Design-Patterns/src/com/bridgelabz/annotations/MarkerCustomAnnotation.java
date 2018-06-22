package com.bridgelabz.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyMarkerAnnot{}

public class MarkerCustomAnnotation {

	
	@MyMarkerAnnot
	public void myAnnotationTestMethod() throws NoSuchMethodException, SecurityException{
	  Class<? extends MarkerCustomAnnotation> cls=this.getClass();
	  Method method= cls.getMethod("myAnnotationTestMethod");
	  if(method.isAnnotationPresent(MyMarkerAnnot.class))
	  {
		  System.out.println("Hey... marker annotation is present.");
	  }
	  else {
		  System.out.println("Marker annotation is not present.");
	  }
	}
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		MarkerCustomAnnotation marker=new MarkerCustomAnnotation();
		marker.myAnnotationTestMethod();
	}
}
