/* Microsoft: DEV276x Learn to Program in Java.
 * 
 * Module 4 | Final Project >  Maze Runner.
 * 
 * November 2 2018
 */
package module4;

import java.util.Scanner;

public class MazeRunner {

	public static Maze myMap = new Maze();
	public static Scanner input = new Scanner(System.in);
	public static int numberOfMoves = 0;
	public static String direction = "";

	public static void main(String[] args) {
		intro();
		while (!myMap.didIWin()) {
			// count the number of moves and print some message note the player.
			numberOfMoves += 1;
			movesMessage();
			if (numberOfMoves == 100) {
				// if the numbers of moves is 100, then quit the game.
				System.out.println("Sorry, but you didn't escape in time- you lose!");
				return;
			}
			userMove();
		}
		// when player win the game, print the message.
		System.out.println("congratulations! And you did it in " + direction + " moves");
	}

	public static void intro() {
		// introduction...
		System.out.println("Welcome the user to Maze Runner!\nHere is your current position:");
		myMap.printMap();
	}

	public static String userMove() {
		// take in desired direction of move, and check if that direction is valid and
		// possible.
		System.out.println("Where would you like to move? (R, L, U, D)");
		direction = input.nextLine();
		while (!direction.equals("R") && !direction.equals("L") && !direction.equals("U") && !direction.equals("D")) {
			return userMove();
		}
		if (myMap.canIMoveRight() && direction.equals("R")) {
			myMap.moveRight();
		} else if (myMap.canIMoveLeft() && direction.equals("L")) {
			myMap.moveLeft();
		} else if (myMap.canIMoveUp() && direction.equals("U")) {
			myMap.moveUp();
		} else if (myMap.canIMoveDown() && direction.equals("D")) {
			myMap.moveDown();
		} else {
			System.out.println("Sorry, you’ve hit a wall.");
		}
		navigatePit();
		myMap.printMap();
		return direction;
	}

	public static void movesMessage() {
		// print message after certain number of move.
		if (numberOfMoves == 50) {
			System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
		} else if (numberOfMoves == 75) {
			System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
		} else if (numberOfMoves == 90) {
			System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
		} else if (numberOfMoves == 100) {
			System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
		}
	}

	public static void navigatePit() {
		// watch out for pits.
		if (myMap.isThereAPit(direction)) {
			System.out.println("Watch out! There's a pit ahead, jump it?");
			String s = input.nextLine(); // prompt a question to the player.
			while (!s.equals("YES") && !s.equals("yes") && !s.equals("y") && !s.equals("Yes") && !s.equals("Y")) {
				// if not "Yes" return navigatePit().
				navigatePit();
			}
			myMap.jumpOverPit(direction);
		}
	}
}
