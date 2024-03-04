package com.springcore.ref;

public class A {
	private int a;
	private B obj;
	
	public A() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public A(int a, B obj) {
		super();
		this.a = a;
		this.obj = obj;
	}

	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public B getObj() {
		return obj;
	}
	public void setObj(B obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "A [a=" + a + ", obj=" + obj + "]";
	}
	
}
