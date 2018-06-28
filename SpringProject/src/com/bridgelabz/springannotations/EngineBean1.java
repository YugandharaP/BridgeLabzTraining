package com.bridgelabz.springannotations;

import org.springframework.stereotype.Component;

@Component
public class EngineBean1 {
	EngineBean1 engine1;

	public EngineBean1(EngineBean1 engine1) {
		this.engine1 = engine1;
		System.out.println("engine1 constructor loaded");
	}

	public EngineBean1() {
	}
}
