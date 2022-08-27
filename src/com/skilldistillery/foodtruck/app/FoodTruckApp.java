package com.skilldistillery.foodtruck.app;

import java.util.Arrays;
import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {
	public static Scanner input = new Scanner(System.in);
	private final static int MAX_FOODTRUCKS = 5;
	FoodTruck[] foodTruck = new FoodTruck[MAX_FOODTRUCKS];

	public static void main(String[] args) {
		FoodTruckApp foodTruckApp = new FoodTruckApp();
		boolean keepGoing = true;
		foodTruckApp.foodTruckInput();

		while (keepGoing) {
			foodTruckApp.printMenu();
			int choice = input.nextInt();
			keepGoing = foodTruckApp.menuSelection(choice);

		}

	}

	public void foodTruckInput() {

		for (int i = 0; i < foodTruck.length; i++) {
			System.out.println("Please enter in the Name of Food Truck " + (i + 1) + ": ");
			String name = input.next();
			if (name.equalsIgnoreCase("quit")) {
				System.out.println("You chosen to quit");
				break;
			}
			System.out.println("Please enter in the Food Type of Food Truck " + (i + 1) + ": ");
			String foodType = input.next();
			System.out.println("Please enter in the Rating of Food Truck " + (i + 1) + ": ");
			int rating = input.nextInt();
			foodTruck[i] = new FoodTruck(name, foodType, rating);
		}

	}

	public void printMenu() {
		System.out.println();
		System.out.println("Please select one from the menu: ");
		System.out.println();
		System.out.println("=================== MENU ====================");
		System.out.println("|                                           |");
		System.out.println("|  1. List all existing food trucks         |");
		System.out.println("|  2. See the average rating of food truck  |");
		System.out.println("|  3. Display the highest-rated food truck  |");
		System.out.println("|  4. Quit the program                      |");
		System.out.println("|                                           |");
		System.out.println("=============================================");
	}

	public boolean menuSelection(int choice) {

		switch (choice) {
		case 1:
			for (int i = 0; i < foodTruck.length; i++) {
				System.out.println(foodTruck[i]);
			}
			break;
		case 2:
			System.out.println(getAverage());
			break;
		case 3:
			System.out.println(getHighestRating());
			break;

		case 4:
			System.out.println("You chosen to quit. Have a good day!");
			return false;
		default:
			System.out.println("Invalid Entry. Please type 1-4 to proceed with the menu!");
			return false;
		}
		return true;
	}

	public int getAverage() {
		int sum = 0;
		int total = 0;
		int result = 0;

		for (FoodTruck i : foodTruck) {
			if (i == null)
				continue;
			sum += i.getRating();
			total++;
		}
		if (sum > 0) {
			result = sum / total;

		}
		return result;
	}

	public int getHighestRating() {
		int max = 0;
		for (FoodTruck i : foodTruck) {
			if (i == null)
				continue;
			if (i.getRating() > max) {
				max = i.getRating();
			}
		}
		return max;
	}

}
