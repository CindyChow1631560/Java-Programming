package com.spring.aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	     //定义一个方法，用于声明切入点表达式，一般的，该方法中，不需要添加其他代码
	     @Pointcut("execution(* com.spring.aop.ProductService.*())")
	     public void declareAspectExpression(){};
         @Before("declareAspectExpression()")//前置通知
         public void beforeMethod(JoinPoint joinPoint){
        		String methodName = joinPoint.getSignature().getName();//获得方法名
        		List<Object> args = Arrays.asList(joinPoint.getArgs());//获得方法的参数列表 
        	 System.out.println("The method "+methodName+" Begin with "+args);
         }
         @After("execution(* com.spring.aop.ProductService.*())")
         public void afterMethod(JoinPoint joinpoint){
        	 String methodName = joinpoint.getSignature().getName();
        	 System.out.println("The method "+methodName+" End");
         }
         @AfterReturning(value="execution(* com.spring.aop.ProductService.*(..))", 
        		 returning="result")
         public void afterReturning(JoinPoint joinpoint, Object result){//result是方法的返回值
        	 String methodName = joinpoint.getSignature().getName();
        	 System.out.println("The method "+methodName+" end with "+result);
         }
         @AfterThrowing(value="execution(* com.spring.aop.ProductService.*(..))",throwing="ex")
         public void afterThrowing(JoinPoint joinpoint, Exception ex){
        	 String methodName = joinpoint.getSignature().getName();
        	 System.out.println("The method "+methodName+" occurs exception "+ex);
         }
         
         /**
          * 环绕通知需要携带ProceedingJoinPoint参数
          * 类似于动态代理的全过程，ProceedingJoinPoint 类型的参数可以决定是否执行目标方法
          * 且环绕通知必须有返回值，返回值即为目标方法的返回值
          */ 
         @Around("execution(* com.spring.aop.ProductService.*(..))")
         public Object aroundMethod(ProceedingJoinPoint joinpoint){
        	 Object result=null;
        	 String methodName = joinpoint.getSignature().getName();
        	 try {
        		 //前置通知
        		 System.out.println("The method "+methodName+" end with "+result);
        		 result=joinpoint.proceed();//执行目标方法
				//返回通知
        		 System.out.println("The method "+methodName+" end with "+result);
			} catch (Throwable e) {
				//异常通知
				// TODO: handle exception
				System.out.println("Exception occurs with "+e);
			}
        	 //后置通知
        	 System.out.println("The method "+methodName+" ends");
        	 //System.out.println("Around");
        	 return result;
         }
}
