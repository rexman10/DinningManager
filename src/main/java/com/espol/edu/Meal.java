package com.espol.edu;

public class Meal {
	private String name;
	private int price;
	private int mealsRemaining;
	
	public Meal(String name, int price, int mealsRemaining) {
		super();
		this.name = name;
		this.price = price;
		this.mealsRemaining = mealsRemaining;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getMealsRemaining() {
		return mealsRemaining;
	}

	public void setMealsRemaining(int mealsRemaining) {
		this.mealsRemaining = mealsRemaining;
	}
	
	public void orderMeal(int quantity) {
		this.mealsRemaining = this.mealsRemaining - quantity;
	}

}
