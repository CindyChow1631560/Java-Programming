package com.spring.aop;

public class Product {
private int id;
private String name;
private Category category;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public void init(){
	System.out.println("init");
}
public void destroy(){
	System.out.println("destroyed");
}


}
