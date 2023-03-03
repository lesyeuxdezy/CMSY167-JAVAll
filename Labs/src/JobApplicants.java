/**
 * Project - Job Applicants
 * Copyright 2023 Howard Community College
 *
 * @author Jeryzza Tomas
 * @version 3.2
 */

package src;

// import file writer, reader

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class JobApplicants {
    public static void main(String[] args) {

        // creating object of fileReader and bufferedReader

        try {
            // scan modify line into the new file "emails.txt"
            BufferedReader bufferedReader = new BufferedReader(new FileReader("applicants.csv"));
            FileWriter fileWriter = new FileWriter("emails.txt");

            // string line class
            String readLine = bufferedReader.readLine();

            while ((readLine = bufferedReader.readLine()) != null) {
                String[] fields = readLine.split(",");

                // create objects for strings
                int id = Integer.parseInt(fields[0].trim());
                String title = fields[1].trim();
                String firstName = fields[2].trim();
                String lastName = fields[3].trim();
                String email = fields[4].trim();
                String position = fields[5].trim();
                String status = fields[6].trim();

                // if the title is missing, use an empty string
                if (title.isEmpty()) {
                    title = "";

                    // if the title contains invalid characters, use an empty string
                } else if (!title.matches("[a-zA-Z]+")) {
                    title = "";
                    System.out.println("Invalid character(s) in title for applicant " + id);
                }
                // if the email address is invalid, disregard this applicant
                if (email.isEmpty() || !email.contains("@")) {
                    System.out.println("Invalid email address for applicant " + id);
                    continue;
                }
                // if the first name contains invalid characters, use an empty string
                if (!firstName.matches("[a-zA-Z]+")) {
                    System.out.println("Invalid character(s) in first name for applicant " + id);
                    firstName = "";
                }
                // if the last name contains invalid characters, use an empty string
                if (!lastName.matches("[a-zA-Z]+")) {
                    System.out.println("Invalid character(s) in last name for applicant " + id);
                    lastName = "";
                }

                StringBuilder messageApplicants = new StringBuilder();
                messageApplicants.append("To: ").append(email).append("\n")
                        .append("From: humanresources@gizmogroupllc.com\n")
                        .append("Subject: Your Gizmo Group Application\n\n")
                        .append("Dear ").append(title).append(" ").append(lastName).append(",\n\n");

                switch (status) {
                    case "Hire":
                        messageApplicants.append("Congratulations! We are delighted to offer you the position of ")
                                .append(position).append(". Please let us know if you accept this offer.\n");
                        break;
                    case "Interview":
                        messageApplicants.append("Thank you for your interest in the position of ")
                                .append(position).append(". WWe'd like to schedule an interview with you.\n")
                                .append("Please let us know when you are available so that we can schedule a time that is convenient for you..\n");
                        break;
                    case "Reject":
                        messageApplicants.append("Thank you for applying for the position of ")
                                .append(position).append(". Unfortunately, we have decided not to proceed with your application..\n")
                                .append("We appreciate your interest in our company and wish you the best of luck in your job search.\n");
                        break;
                    default:
                        // if the applicant's status is invalid, skip
                        System.out.println("Invalid status for applicant " + id);
                        continue;
                }

                fileWriter.write(messageApplicants.toString());
                fileWriter.write("\n");
            }
            // close all scanners and files
            bufferedReader.close();
            fileWriter.close();

            // create exception file handling
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}