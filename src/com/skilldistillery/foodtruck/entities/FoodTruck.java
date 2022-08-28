package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	private static int truckId = 0;

	private int id;
	private String name;
	private String foodType;
	private int rating;

	public FoodTruck() {
		this.id = truckId;
		truckId++;
	}

	public FoodTruck(String name, String foodType, int rating) {
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		this.id = truckId;
		truckId++;
	}

	public String toString() {
		return "------Food Truck------\n" + "ID: " + id + "\nName: " + name + "\nFood Type: " + foodType + "\nRating: "
				+ rating + "\n----------------------";
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
