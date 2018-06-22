package com.bridgelabz.singletonpatterns;

import java.io.Serializable;

public class SerializedSingleton implements Serializable{

	    private static final long serialVersionUID =1000L;

	    private SerializedSingleton(){}
	    
	    private static class SingletonHelper{
	        private static final SerializedSingleton instance = new SerializedSingleton();
	    }
	    
	    public static SerializedSingleton getInstance(){
	        return SingletonHelper.instance;
	    }
	}

