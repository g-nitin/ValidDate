/*
By Nitin Gupta
Lab02
9/11/21
 */

import java.util.Scanner;

public class lab02VaildDate {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("\nEnter a date in the format month/day/year");
        String date = keyboard.nextLine();
        String copyDate = date; // copy of date

        /// Parsing from copyDate...
        int forwardSlash = copyDate.indexOf("/"); // gives the index of the FIRST "/"
        String month = copyDate.substring(0, forwardSlash); // STORES the month from the date
        copyDate = copyDate.substring(forwardSlash+1); // CUTS the month from the date

        forwardSlash = copyDate.indexOf("/"); // gives the index of the SECOND "/"
        String day = copyDate.substring(0, forwardSlash); // STORES the day from the date

        // STORES the digits remaining in date (which is the year)
        String year = copyDate.substring(forwardSlash+1);

        /// Converting String to int...
        int monthInt = Integer.parseInt(month);
        int dayInt = Integer.parseInt(day);
        int yearInt = Integer.parseInt(year);

        /// Error Checking...

        if (1 <= monthInt && monthInt <= 12) // If the month is valid
        {

            // If the month has 30 days...
            if (monthInt == 4 || monthInt == 6 || monthInt == 9 || monthInt == 11)
            {
                if (1 > dayInt || dayInt > 30) // the date is invalid
                {
                    System.out.println("SORRY! Date invalid!" +
                        "\nMaybe they day you entered for that month isn't valid." +
                            " Should be between 1 and 30.");
                    System.exit(0);
                }
            }

            else if (monthInt != 2) // all months excluding Feb and the all 30-day months
            {
                if (1 > dayInt || dayInt > 31) // the date is invalid
                {
                    System.out.println("SORRY! Date invalid!" +
                            "\nMaybe they day you entered for that month isn't valid.");
                    System.exit(0);
                }
            }

            else // for Feb
            {
                if (dayInt == 29) // if it's 29th Feb: check for leap year
                {
                    if (yearInt % 4 == 0)
                    {
                        if (yearInt % 100 == 0 && yearInt % 400 != 0) // year is not a leap year
                        {
                            System.out.println("SORRY! Date invalid!" +
                                    "\nMaybe the date you entered isn't valid as that year isn't " +
                                    "a leap year.");
                            System.exit(0);
                        }
                    }
                }

                else if (1 > dayInt || dayInt > 28) // the date is invalid
                {
                    System.out.println("SORRY! Date invalid!" +
                            "\nMaybe they day you entered for February isn't valid for that year.");
                    System.exit(0);
                }
            }

        }
        else // The month is not valid
        {
            System.out.println("Sorry! The month you have entered is not valid!");
            System.exit(0);
        }

        // If nothing is wrong, then the date is valid...
        System.out.println(date + " is a valid date!");

    }

}
