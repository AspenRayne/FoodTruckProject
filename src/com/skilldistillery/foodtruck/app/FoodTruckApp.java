package com.skilldistillery.foodtruck.app;

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
			System.out.print("*Enter \"quit\" to exit*\nPlease enter in the Name of Food Truck " + (i + 1) + ": ");
			String name = input.nextLine();
			if (name.equalsIgnoreCase("quit")) {
				System.out.print("You chosen to quit");
				break;
			}
			System.out.print("Please enter in the Food Type of Food Truck " + (i + 1) + ": ");
			String foodType = input.nextLine();
			System.out.print("Please enter in a whole number between 0-5 for a Rating of Food Truck " + (i + 1) + ": ");
			int rating = input.nextInt();
			while (rating > 5 || rating < 0) {
				System.out.print("WHOOPS! please enter a whole number between 0-5: ");
				rating = input.nextInt();
			}
			input.nextLine();
			System.out.println();
			foodTruck[i] = new FoodTruck(name, foodType, rating);
		}

	}

	public void printMenu() {
		System.out.println();
		System.out.println("=================== MENU ====================");
		System.out.println("|                                           |");
		System.out.println("|  1. List all existing food trucks         |");
		System.out.println("|  2. See the average rating of food trucks |");
		System.out.println("|  3. Display the highest-rated food truck  |");
		System.out.println("|  4. Quit the program                      |");
		System.out.println("|                                           |");
		System.out.println("=============================================");
		System.out.print("Please select one of the options from the menu above: ");
	}

	public boolean menuSelection(int choice) {

		switch (choice) {
		case 1:
			System.out.println();
			System.out.println("List of existing Food Trucks: ");
			System.out.println("==============================");
			for (int i = 0; i < foodTruck.length; i++) {
				if(foodTruck[i] != null)
				System.out.println(foodTruck[i]);
			}
			break;
		case 2:
			System.out.println();
			System.out.print("The average rating of the food trucks are: ");
			System.out.println(getAverage());
			break;
		case 3:
			System.out.println();
			System.out.println("The highest Rated Food Truck is: ");
			System.out.println(getHighestRating());
			break;
		case 4:
			System.out.println("I hope you enjoyed using FoodTruckApp! See you next time!");
			return false;
		default:
			System.out.println("Invalid Entry. Please enter numbers 1-4 to proceed with the menu!");
			
		}
		return true;
	}

	public double getAverage() {
		double sum = 0;
		double total = 0;
		double result = 0;

		for (FoodTruck i : foodTruck) {
			if (i == null)
				continue;
			sum += i.getRating();
			total++;
		}
		if (sum > 0) {
			result = sum / total;

		}
		return Double.valueOf(String.format("%.2f", result));
	}

	public String getHighestRating() {
		int max = 0;
		String highestRatedTruck = " ";
		for (FoodTruck i : foodTruck) {
			if (i == null)
				continue;
			if (i.getRating() > max) {
				max = i.getRating();
				highestRatedTruck = i.toString();
			}

		}
		return highestRatedTruck;
	}

}
