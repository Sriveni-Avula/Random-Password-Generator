package com.tech.task;
import java.security.SecureRandom;
import java.util.Scanner;
public class RandomPasswordGenerator 
{

	  public static void main(String[] args)
	  {
		        Scanner scanner = new Scanner(System.in);

		        System.out.print("Enter the length of the password: ");
		        int length = scanner.nextInt();

		        System.out.print("Include Uppercase Letters? (y/n): ");
		        boolean includeUppercase = scanner.next().equalsIgnoreCase("y");

		        System.out.print("Include Lowercase Letters? (y/n): ");
		        boolean includeLowercase = scanner.next().equalsIgnoreCase("y");

		        System.out.print("Include Numbers? (y/n): ");
		        boolean includeNumbers = scanner.next().equalsIgnoreCase("y");

		        System.out.print("Include Special Characters? (y/n): ");
		        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("y");

		        String generatedPassword = generatePassword(length, includeUppercase, includeLowercase, includeNumbers, includeSpecialChars);

		        System.out.println("\nGenerated Password: " + generatedPassword);

		        scanner.close();
		    }

		    private static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase,
		                                           boolean includeNumbers, boolean includeSpecialChars) {
		        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
		        String numberChars = "0123456789";
		        String specialChars = "!@#$%^&*()-=_+[]{}|;:'\",.<>/?";

		        StringBuilder validChars = new StringBuilder();
		        if (includeUppercase) validChars.append(uppercaseChars);
		        if (includeLowercase) validChars.append(lowercaseChars);
		        if (includeNumbers) validChars.append(numberChars);
		        if (includeSpecialChars) validChars.append(specialChars);

		        if (validChars.length() == 0) {
		            System.out.println("Error: At least one character type must be selected.");
		            System.exit(1);
		        }

		        SecureRandom random = new SecureRandom();
		        StringBuilder password = new StringBuilder();

		        for (int i = 0; i < length; i++) {
		            int randomIndex = random.nextInt(validChars.length());
		            password.append(validChars.charAt(randomIndex));
		        }

		        return password.toString();
		    }
		}

