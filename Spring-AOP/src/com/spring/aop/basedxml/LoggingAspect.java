package com.spring.aop.basedxml;

import org.aspectj.lang.ProceedingJoinPoint;


public class LoggingAspect {
	   
   public Object log(ProceedingJoinPoint joinpoint) throws Throwable{
	   System.out.println("log start "+joinpoint.getSignature().getName());
	   Object object=joinpoint.proceed();//ִ��Ŀ�귽��
	   System.out.println("log end "+joinpoint.getSignature().getName());
	   return object;
   }
}
