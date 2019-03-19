//Microsoft: DEV276x Learn to Program in Java (Module Project - Crypto)

package module3;

import java.util.Scanner;

public class Crypto {

	public static void main(String[] args) {

		System.out.print("Plaintext: ");
		Scanner input = new Scanner(System.in);
		String message = input.nextLine();
		System.out.print("key: ");
		int key = input.nextInt();
		System.out.print("The number of letters per group: ");
		int groupNumber = input.nextInt();
		System.out.println("Cyphertext: " + encryptString(message, key, groupNumber));
		System.out.println("--------------------------------------------------------------");
		
		System.out.print("Cyphertext: ");
		String message2 = input.nextLine();
		System.out.print("Key: ");
		int key2 = input.nextInt();
		System.out.println("The message is: " + decrypt(message2, key2));		
	}

	// PART 1 - NORMALIZE TEXT
	public static String normalizeText(String str) {
		return str.replaceAll("[^a-zA-Z]+", "").toUpperCase(); // RegExr --> [^a-zA-Z]+
	}

	// PART 2 - CAESAR CIPHER
	public static String caesarify(String str, int key) {

		String encipher = "";
		key = convKeys(key);
		for (int i = 0; i < str.length(); i++) {
			// offset the character
			if (((char) (str.charAt(i) + key)) > 'Z') {
				encipher += (char) (str.charAt(i) - (26 - key));
			} else if ((int) (str.charAt(i) + key) < 0) {
				encipher += (char) (str.charAt(i) + (26 - key));
			} else {
				encipher += (char) (str.charAt(i) + key);
			}
		}
		return encipher;
	}

	public static int convKeys(int key) {
		// if the key more than 26 or negative, the convert the key's value.
		if (key > 26) {
			key -= 26;
			key = convKeys(key);
		} else if (key < 0) {
			key += 26;
			key = convKeys(key);
		}
		return key;
	}

	// PART 3 - CODEGROUPS
	public static String groupify(String str, int n) {
		String spString = "";

		if (str.length() >= n) {
			// Check the key must less than the String.

			if ((str.length() % n) == 0) {
				// Check the length of string can be divided by key.

				for (int i = 0, j = i + n; i <= (str.length() - n); i += n, j += n) {
					// split the String
					spString = spString + str.substring(i, j) + " ";
				}
			} else {

				int addX = str.length() % n; // The numbers of x need to be add into the str.
				for (int i = 0; i < addX; i++) {
					str += "x";
				}
				for (int i = 0, j = i + n; i <= (str.length() - n); i += n, j += n) {
					// split the String
					spString = spString + str.substring(i, j) + " ";
				}
			}
		} else {
			return "ERROR! The Key shouldn't less than the message's length.";
		}

		return spString;
	}

	// PART 4 - PUTTING IT ALL TOGETHER
	public static String encryptString(String str, int key, int numberOfParts) {
		String cipherText = groupify(caesarify((normalizeText(str)), key), numberOfParts);
		return cipherText;
	}

	// PART 5 - HACKER PROBLEM - DECRYPT
	public static String ungroupify(String str) {
		// Returns the string without any spaces
		str = str.replaceAll(" ", "");
		return str;
	}

	public static String decryptString(String str, int key) {
		String string = "";
		key = convKeys(key);
		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i) + key) < 0) {
				string += (char)(str.charAt(i) - (26+key));
			} else if ((str.charAt(i) + key) > 'Z') {
				string += (char)(str.charAt(i) + (26-key));
			}else {
				string += (char)(str.charAt(i)-key);
			}
		}
		return string;
	}
	public static String decrypt(String str, int key) {
		str = decryptString(ungroupify(str), key);
		return str;
	}
	

}