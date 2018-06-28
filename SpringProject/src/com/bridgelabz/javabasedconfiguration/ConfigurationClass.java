package com.bridgelabz.javabasedconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component(value="com.bridgelabz.javabasedconfiguration")
public class ConfigurationClass {

	 @Bean(name = "comp", initMethod = "turnOn", destroyMethod = "turnOff")
	    Computer computer(){
		 System.out.println("constructor");
	        return new Computer();
	        
	    }
}
