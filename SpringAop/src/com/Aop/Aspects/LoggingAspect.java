package com.Aop.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Before("execution(* com.Aop.Model.Circle.getName())")
	public void LoggingAdvice() {
		System.out.println("Advice runs and then get will be called");
	}
	
	@AfterReturning(pointcut="args(name)",returning="returnString")
	public void SecondAdvice(String name,String returnString) {
		System.out.println("Advice runs and afterreturning the value"+name+" get will be called and return this"+returnString);
	}
	
	@Pointcut("execution(* get*())")
	public void getAllGetters() {
		
	}
	
	@Around("execution(* *get*())")
	public Object AroundAdvice(ProceedingJoinPoint pjp) {
		
		Object returnValue=null;
		
		
		try {
			System.out.println("beforeAdvice");
			pjp.proceed();
			System.out.println("Afteradvice");
		} catch (Throwable e) {
			System.out.println("AterException");
		}
		System.out.println("Finally");
		
		return returnValue;
		
	}
	
	@Pointcut("within(com.Aop.Model.Circle)")
	public void allCircleMethods() {}
}
