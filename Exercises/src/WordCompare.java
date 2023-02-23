package src;
 /**
 * Alphabetize Word - An example class for assignment: Exercise - Word Compare
 * Copyright 2023 Howard Community College
 *
 * @author Jeryzza Tomas
 * @version 3.2
 */

import java.util.Scanner;

public class WordCompare {
    public static void main(String[] args) {

        // create a Scanner
        Scanner input = new Scanner(System.in);

        // create a Yes/No prompt to ask the user if they want to continue or quit
        boolean optionCompare = true;

        // prompt the user to type to words
        while (optionCompare) {
            System.out.println("Please enter a word: ");
            String firstWord = input.nextLine().trim();
            System.out.println("Please enter another word: ");
            String secondWord = input.nextLine().trim();

            // word comparison of two words
            int wordCompare = firstWord.compareToIgnoreCase(secondWord); // case insensitive

            // check which word comes first or the same word
            if (wordCompare < 0) {
                System.out.println(firstWord + " comes before " + secondWord);
            } else if (wordCompare == 0) {
                System.out.println(firstWord + " and " + secondWord + " are the same word.");
            } else {
                System.out.println(secondWord + " comes before " + firstWord);
            }
            // ask if the user want to compare more words
            System.out.println("Would you like to compare more words? (Yes/No)");

            // ask if the user wants to continue to compare words again or exit
            String quit = input.nextLine().trim();
            if (quit.equalsIgnoreCase("No")) {
                optionCompare = false;
                // print goodbye message if the user answered No
                System.out.println("Goodbye.");
            }
        }
    }
}