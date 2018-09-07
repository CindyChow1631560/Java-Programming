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
	     //����һ�����������������������ʽ��һ��ģ��÷����У�����Ҫ�����������
	     @Pointcut("execution(* com.spring.aop.ProductService.*())")
	     public void declareAspectExpression(){};
         @Before("declareAspectExpression()")//ǰ��֪ͨ
         public void beforeMethod(JoinPoint joinPoint){
        		String methodName = joinPoint.getSignature().getName();//��÷�����
        		List<Object> args = Arrays.asList(joinPoint.getArgs());//��÷����Ĳ����б� 
        	 System.out.println("The method "+methodName+" Begin with "+args);
         }
         @After("execution(* com.spring.aop.ProductService.*())")
         public void afterMethod(JoinPoint joinpoint){
        	 String methodName = joinpoint.getSignature().getName();
        	 System.out.println("The method "+methodName+" End");
         }
         @AfterReturning(value="execution(* com.spring.aop.ProductService.*(..))", 
        		 returning="result")
         public void afterReturning(JoinPoint joinpoint, Object result){//result�Ƿ����ķ���ֵ
        	 String methodName = joinpoint.getSignature().getName();
        	 System.out.println("The method "+methodName+" end with "+result);
         }
         @AfterThrowing(value="execution(* com.spring.aop.ProductService.*(..))",throwing="ex")
         public void afterThrowing(JoinPoint joinpoint, Exception ex){
        	 String methodName = joinpoint.getSignature().getName();
        	 System.out.println("The method "+methodName+" occurs exception "+ex);
         }
         
         /**
          * ����֪ͨ��ҪЯ��ProceedingJoinPoint����
          * �����ڶ�̬�����ȫ���̣�ProceedingJoinPoint ���͵Ĳ������Ծ����Ƿ�ִ��Ŀ�귽��
          * �һ���֪ͨ�����з���ֵ������ֵ��ΪĿ�귽���ķ���ֵ
          */ 
         @Around("execution(* com.spring.aop.ProductService.*(..))")
         public Object aroundMethod(ProceedingJoinPoint joinpoint){
        	 Object result=null;
        	 String methodName = joinpoint.getSignature().getName();
        	 try {
        		 //ǰ��֪ͨ
        		 System.out.println("The method "+methodName+" end with "+result);
        		 result=joinpoint.proceed();//ִ��Ŀ�귽��
				//����֪ͨ
        		 System.out.println("The method "+methodName+" end with "+result);
			} catch (Throwable e) {
				//�쳣֪ͨ
				// TODO: handle exception
				System.out.println("Exception occurs with "+e);
			}
        	 //����֪ͨ
        	 System.out.println("The method "+methodName+" ends");
        	 //System.out.println("Around");
        	 return result;
         }
}
