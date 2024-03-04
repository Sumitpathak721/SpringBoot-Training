package com.springcore.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Pepsi implements InitializingBean, DisposableBean{
	private double price;
	
	public Pepsi() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void afterPropertiesSet() throws Exception{
		// init
		System.out.println("taking pepsi: init");
	}
	
	public void destroy() throws Exception{
		System.out.println("Going to put bottle back to shop");
	}
	
	

	@Override
	public String toString() {
		return "Pepsi [price=" + price + "]";
	}
}
