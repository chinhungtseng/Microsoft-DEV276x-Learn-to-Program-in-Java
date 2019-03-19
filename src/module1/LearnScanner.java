package module1;
import java.util.Scanner;

public class LearnScanner {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("What\'s your name? ");
		String name = input.next();
		
		System.out.print("Age: ");
		int age = input.nextInt();
		
		System.out.print("Weight: ");
		double weight = input.nextDouble();
		
		System.out.print(name + " is " + age + " years old, and " + weight + " kg.");
		
	}
}