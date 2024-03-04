package com.springcore.auto.wire;

public class Emp {
	private Address address;

	public Emp() {
		super();
	}
	
	public Emp(Address add) {
		super();
		System.out.println("inside Constructore;");
		this.address = add;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		System.out.println("Setting Values");
		this.address = address;
	}

	@Override
	public String toString() {
		return "Emp [address=" + address + "]";
	}
	
	
	
}
