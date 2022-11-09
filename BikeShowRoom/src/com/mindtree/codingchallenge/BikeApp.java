package com.mindtree.codingchallenge;

import java.util.Scanner;

public class BikeApp {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		boolean isContinue = true;
		System.out.println("Enter the number of bikes in showroom");
		int noOfBikes = scan.nextInt();

		Bike[] bikes = new Bike[noOfBikes];

		do {
			int choice = displayMenu();
			switch (choice) {
			case 1:
				getCreatedBikes(bikes);

				break;
			case 2:
				Bike[] sortedBikes = displayBikesSortedByName(bikes);
				displayingAllBikes(sortedBikes);

				break;
			case 3:
				Bike[] sortedWithTypeAndCC = displayBikesSortedByTypeAndCc(bikes);
				displayingAllBikes(sortedWithTypeAndCC);
				break;

			case 4:
				Bike[] sortByPrice = findingBikesBasedOnPrice(bikes);
				displayingAllBikes(sortByPrice);
				break;
			case 5:
				System.out.println("Enter name");
				String name = scan.next();
				scan.nextLine();
				System.out.println("Enter model");
				String model = scan.nextLine();
				searchingBikeWithNameAndModel(bikes, name, model);
				break;
			case 6:
				isContinue = false;
				System.out.println("Out of App");
				break;
			default:
				System.out.println("Enter a valid choice");
				break;
			}

		} while (isContinue);

	}

	private static Bike[] findingBikesBasedOnPrice(Bike[] bikes) {
		System.out.println("Least price Bike is ");
		System.out.println("bike name is " + bikes[0].getName() + " bike model is " + bikes[0].getModel()
				+ " bike type is " + bikes[0].getType() + " bike engine is " + bikes[0].getEngineCC() + "bike price is "
				+ bikes[0].getPrice());
		System.out.println("High expensive Bike is");
		System.out.println("bike name is " + bikes[bikes.length] + " bike model is " + bikes[bikes.length].getModel()
				+ " bike type is " + bikes[bikes.length].getType() + " bike engine is "
				+ bikes[bikes.length].getEngineCC() + "bike price is " + bikes[bikes.length].getPrice());
		return bikes;
	}

	private static Bike[] searchingBikeWithNameAndModel(Bike[] bikes, String name, String model) {
		int first = 0;
		int last = bikes.length - 1;
		int mid = (first + last) / 2;
		while (first <= last) {
			for (int i = 0; i < bikes.length; i++) {
				if (model.compareTo(bikes[mid].getModel()) > 0 && name.compareTo(bikes[mid].getName()) > 0) {
					first = mid + 1;
				} else if (model.compareTo(bikes[mid].getModel()) == 0 && name.compareTo(bikes[mid].getName()) == 0) {
					System.out.println("Element is found at index: " + mid);
					break;
				} else {
					last = mid - 1;
				}
				mid = (first + last) / 2;
			}
		}
		if (first > last) {
			System.out.println("bike is not found!");
		}
		return bikes;

	}

	private static Bike[] displayBikesSortedByTypeAndCc(Bike[] bikes) {
		if (bikes != null) {
			for (int i = 0; i < bikes.length; i++) {
				for (int j = i + 1; j < bikes.length; j++) {
					if (bikes[i].getType().compareTo(bikes[j].getType()) > 0
							&& bikes[i].getEngineCC() > (bikes[j].getEngineCC())) {
						Bike temp = bikes[i];
						bikes[i] = bikes[j];
						bikes[j] = temp;
					}
				}
			}
			// displayingAllBikes(bikes);

		} else {
			System.out.println(" no bikes prsent");
		}

		return bikes;
	}


	private static Bike[] displayBikesSortedByName(Bike[] bikes) {

		for (int i = 1; i < bikes.length; i++) {
			Bike temp = bikes[i];
			int j = i - 1;
			while (j >= 0 && bikes[j].getName().compareTo(temp.getName()) > 0) {
				bikes[j + 1] = bikes[j];
				j = j - 1;
			}
			bikes[j + 1] = temp;
		}

		return bikes;

	}

	private static void getCreatedBikes(Bike[] bikes) {

		for (int i = 0; i < bikes.length; i++) {
			System.out.println("Enter name of a bike");
			String name = scan.next();
			scan.nextLine();
			System.out.println("Enter model of a bike");
			String model = scan.nextLine();

			System.out.println("Enter type of a bike");
			String type = scan.nextLine();

			System.out.println("Enter engineCC of a bike");
			int engineCC = scan.nextInt();

			System.out.println("Enter price of a bike");
			double price = scan.nextDouble();
			bikes[i] = new Bike(name, model, type, engineCC, price);
		}

	}

	private static void displayingAllBikes(Bike[] bikes) {
		System.out.println("The details of Bikes are:");
		for (int i = 0; i < bikes.length; i++) {
			System.out.println(" " + bikes[i].getName());
			System.out.println(" " + bikes[i].getModel());
			System.out.println(" " + bikes[i].getType());
			System.out.println(" " + bikes[i].getEngineCC());
			System.out.println(" " + bikes[i].getPrice());
			System.out.println("========================");
		}

	}

	private static int displayMenu() {
		System.out.println("Enter your choice");
		System.out.println("1.Add new bike to the showroom");
		System.out.println("2.Display the bikes sorted by name");
		System.out.println("3.Display the bikes sorted by type and then cc");
		System.out.println("4.Find the least and most expensive bikes from the showroom");
		System.out.println("5.Searching the bike with name and model");
		System.out.println("6.Exit");
		int choice = scan.nextInt();
		return choice;
	}
}
