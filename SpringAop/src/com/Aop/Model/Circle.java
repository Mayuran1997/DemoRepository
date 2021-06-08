package com.Aop.Model;

public class Circle {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String setNameandReturn(String name) {
		this.name = name;
		return "Mayuran";
	}
	
}
