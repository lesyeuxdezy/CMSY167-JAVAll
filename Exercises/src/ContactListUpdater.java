/**
 * Exercise - Format Contact List
 * Copyright 2023 Howard Community College
 *
 * @author Jeryzza Tomas
 * @version 3.2
 */

package src;

// import scanner, file input and writer

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;


public class ContactListUpdater {

    // format the line of the file
    public static String modifyText(String string) {

        int i;
        int line = 0;
        String firstName = "";
        String formattedData = "";

        // create a loop that is repeated for each character in the text line
        for (i = 0; i < string.length(); i++) {


            // pass each character up to the first ','
            if (line == 0) {
                if (string.charAt(i) == ',')
                    line++;
                continue;
            }

            // last name appears should appear first in the formatted text file
            // followed by first name, but first name appears first in our current text file
            else if (line == 1) {

                if (string.charAt(i) == ',') {
                    firstName += " ";
                    line++;
                    continue;
                }
                firstName += string.charAt(i);
            }

            // last name is the first character in the formatted file
            else if (line == 2) {

                if (string.charAt(i) == ',') {
                    formattedData += ", " + firstName + "<";
                    line++;
                    continue;
                }
                formattedData += string.charAt(i);
            }

            // add email
            else if (line == 3) {
                if (i == string.length() - 1) {
                    formattedData += string.charAt(i) + ">";
                    continue;
                }
                formattedData += string.charAt(i);
            }
        }

        return formattedData;

    }

    public static void main(String[] args) {


        try {
            // scan the contacts file
            File myFile = new File("contacts.txt");

            // run formatted file
            FileWriter formattedFile = new FileWriter("formatted-contacts.txt");

            // create a scanner
            Scanner scanner = new Scanner(myFile);


            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // format the line
                String formattedData = modifyText(line);

                // scan modify line into the new file "formatted-contacts"
                formattedFile.write(formattedData);

                // if there is a next line in the contacts file, we will add a 'n' character.
                // to implement a new line into the formatted-contacts file
                if (scanner.hasNextLine())
                    formattedFile.write("\n");
            }

            // close all scanners and files
            scanner.close();
            formattedFile.close();

            System.out.println("It has been completed successfully!");
        }
        // create exception file handling
        catch (FileNotFoundException file) {
            System.out.println("There has been an error..");
            file.printStackTrace();
        } catch (Exception file) {
            System.out.println("There has been an error..");
            file.printStackTrace();
        }

    }
}