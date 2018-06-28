package com.bridgelabz.javabasedconfiguration;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

public class Computer {
	public void turnOn(){
        System.out.println("Load operating system");
    }
    public void turnOff(){
        System.out.println("Close all programs");
    }
}
