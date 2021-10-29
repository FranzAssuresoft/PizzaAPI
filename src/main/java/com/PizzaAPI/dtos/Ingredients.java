package com.PizzaAPI.dtos;

public class Ingredients {
	private String Id;
	private String Name;
	private double Price;
	
	public Ingredients() {
		
	}
	public Ingredients(String id, String name, double price) {
		super();
		Id = id;
		Name = name;
		Price = price;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}


}
