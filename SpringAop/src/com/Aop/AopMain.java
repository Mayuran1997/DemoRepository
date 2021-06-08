package com.Aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Aop.service.ShapeService;

public class AopMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx= new ClassPathXmlApplicationContext("spring.xml");
		
		ShapeService service= ctx.getBean("shapeService", ShapeService.class);
		//System.out.println("print--->"+service.getCircle().getName());
		service.getCircle();
	}

}
