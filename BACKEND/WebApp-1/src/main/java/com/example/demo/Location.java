package com.example.demo;

public class Location {

	private String name;
	private int value;
	
	public Location()
	{
		
	}

	public Location(String name, int value) {
		super();
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Location [name=" + name + ", value=" + value + "]";
	}
	
	
	
	
}
