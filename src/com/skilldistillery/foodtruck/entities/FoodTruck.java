package com.skilldistillery.foodtruck.entities;

public class FoodTruck {

	private FoodTruck [] trucks;
	private int id = 0;
	private String name;
	private String foodType;
	private int rating;
	
	public FoodTruck(){}
	
	public FoodTruck(String name, String foodType, int rating) {
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
	}
	
	public FoodTruck(int id, String name, String foodType, int rating) {
		this(name, foodType, rating);
		this.id = id;
	}
	
	public String toString() {
		return " Food trucks ID: " + id + ", Food trucks name: " + name + 
				", Food trucks food type: " + foodType + ", Food trucks rating: " + rating;
	}
	public void nextTruckId(FoodTruck f) {
		trucks[id] = f;
		id++;
	}
	
	
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
