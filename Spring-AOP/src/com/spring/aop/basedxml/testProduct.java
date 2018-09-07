package com.spring.aop.basedxml;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
         ProductService s= context.getBean(ProductService.class);
         s.doSomeService();
	}

}
