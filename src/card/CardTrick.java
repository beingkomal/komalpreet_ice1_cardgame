/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * ICE 1 - CardTrick Class
 * Author: Komalpreet Kaur
 * Student Number: 991777431
 * Date: 2025-01-26
 */

package card;

import java.util.Random;
import java.util.Scanner;

public class CardTrick {
    public static void main(String[] args) {
        Random random = new Random();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        int[] values = new int[7];
        String[] cardSuits = new String[7];

        // Generate random cards
        for (int i = 0; i < 7; i++) {
            values[i] = random.nextInt(13) + 1;  // Generate values between 1-13
            cardSuits[i] = suits[random.nextInt(4)];  // Select a random suit
            System.out.println(cardSuits[i] + " " + values[i]);
        }

        // User input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a card value (1-13): ");
        int userValue = scanner.nextInt();

        System.out.print("Enter a suit (0=Hearts, 1=Diamonds, 2=Clubs, 3=Spades): ");
        int suitIndex = scanner.nextInt();
        
        // Validate suit input
        while (suitIndex < 0 || suitIndex > 3) {
            System.out.print("Invalid suit. Enter 0=Hearts, 1=Diamonds, 2=Clubs, 3=Spades: ");
            suitIndex = scanner.nextInt();
        }

        String userSuit = suits[suitIndex];

        // Search for the user's card
        boolean found = false;
        for (int i = 0; i < 7; i++) {
            if (values[i] == userValue && cardSuits[i].equals(userSuit)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }

        // Lucky card logic
        int luckyValue = 7;
        String luckySuit = "Hearts";
        boolean luckyCardFound = false;
        for (int i = 0; i < 7; i++) {
            if (values[i] == luckyValue && cardSuits[i].equals(luckySuit)) {
                luckyCardFound = true;
                break;
            }
        }

        if (luckyCardFound) {
            System.out.println("You found the lucky card: " + luckySuit + " " + luckyValue);
        } else {
            System.out.println("Sorry, the lucky card is not in the magic hand.");
        }

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
