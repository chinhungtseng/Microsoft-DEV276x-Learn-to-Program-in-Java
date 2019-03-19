// Odds and Evens game!

package module2;

import java.util.*;

public class OddsAndEvens {

	public static void main(String[] args) {

		// PART 1 - PICK ODDS OR EVENS.
		Scanner input = new Scanner(System.in);
		System.out.println("Let’s play a game called \"Odds and Evens\"");
		// Ask the player's name.
		System.out.print("What is your name?");
		System.out.println();
		String name = input.nextLine();
		System.out.print("Hi " + name + ", which do you choose? (O)dds or (E)vens?");
		String letter = input.nextLine();

		// check ODDS OR EVENS?
		if (letter.equals("O")) {
			System.out.println(name + " has picked odds! The computer will be evens.");
		} else if (letter.equals("E")) {
			System.out.println(name + " has picked evens! The computer will be odds.");
		}
		System.out.println("-----------------------------------------------");

		// PART 2 - PLAY THE GAME.
		System.out.print("How many \"fingers\" do you put out?");
		int userNumber = input.nextInt();
		Random random = new Random();
		int computerNumber = random.nextInt(6);

		System.out.println("The computer plays " + computerNumber + " \"fingers\".");
		System.out.println("-----------------------------------------------");

		// PART 3 - WHO WON?
		int sum = userNumber + computerNumber;
		System.out.println(userNumber + " + " + computerNumber + " = " + sum);

		if (sum % 2 == 0) {
			System.out.println(sum + " is ...even!");
			if (userNumber % 2 == 0) {
				System.out.println("You win!");
			} else {
				System.out.println("You lose!");
			}
		} else {
			System.out.println(sum + " is ...odd!");
			if (userNumber == 0) {
				System.out.println("You lose!");
			} else {
				System.out.println("You Win!");
			}
		}
		System.out.println("-----------------------------------------------");
	}

}
