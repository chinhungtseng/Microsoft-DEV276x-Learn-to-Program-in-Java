package module1;
import java.util.Scanner;

public class TripPlanner {
	
	public static void main(String[] args) {
		Greeting(); //part 1
		TravelTimeAndBudget(); // part 2
		timeDifference(); // part 3
		countryArea(); // part 4
	}
	public static void Greeting() {
		Scanner input = new Scanner(System.in);
		
		// Part 1 - GREETING
		System.out.println("Welcome to Vacation Planner!");
		System.out.print("What is your name? ");
		String name = input.nextLine();
		System.out.print("Nice to meet you " + name + " ,where are you travelling to? ");
		String location = input.nextLine();
		System.out.println("Great! " + location + " sounds like a great trip");
		System.out.println("***********");
		System.out.println();
		System.out.println();
	}
	
	public static void TravelTimeAndBudget() {
		
		// Part 2 - TRAVEL TIME AND BUDGET
		Scanner input = new Scanner(System.in);
		
		System.out.print("How many days are you going to spend travelling? ");
		int travetime = input.nextInt();
		System.out.print("How much money, in USD, are you planning to spend on your trip? ");
		double budget = input.nextDouble();
		System.out.print("What is the three letter currency symbol for your travel destination? ");
		String currency = input.next();
		System.out.print("How many " + currency + " are there in 1 USD? ");
		double rate = input.nextDouble();
		
		System.out.println();
		System.out.println();
		
		
		System.out.println("If you are travelling for " + (int)travetime + " days that is the same as " + (int)(travetime*24) + " hours or " + (int)(travetime*24*60) + " minutes");
		System.out.println("If you are going to spend $" + budget + " USD that means per day you can spend up to $" + (((int)(budget/travetime*100))/100.0) + " USD");
		System.out.println("Your total budget in " + currency + " is " + (budget*rate) + ", which per day is " + (((int)(budget*rate/travetime*100))/100.0) + " "+ currency);
		System.out.println("***********");
		System.out.println();
		System.out.println();
	}	
	public static void timeDifference() {
		
		// PART 3 – TIME DIFFERENCE
		Scanner input = new Scanner(System.in);
		
		System.out.print("What is time difference , in hour, betweedn your home and your destination? ");
		int hours = input.nextInt();
		System.out.println("That means that when it is midnight at home it will be " + (hours % 24) + ":00 in your destination");
		System.out.println("and when it is noon at home it will be " + ((12 + hours) % 24) + ":00");
	}
	
	public static void countryArea() {
		
		// PART 4 – COUNTRY AREA
		Scanner input = new Scanner(System.in);
		System.out.print("What is the square area of your destination country in km2? ");
		Double area = input.nextDouble();
		System.out.println("In miles2 that is " + (area * 0.621371));
	}
	
	
	
	

}
