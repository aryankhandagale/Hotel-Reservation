package com.bridgelabz;

import java.util.Scanner;

// This class contains main().

public class Main {

    /*  @Description: This class has the main method of HotelReservation .
        @Parameters: String[] args.
        @Return: -
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HotelReservation hotelReservation = new HotelReservation();

        System.out.println("Select Customer Type:");
        System.out.println("1. Regular");
        System.out.println("2. Reward");
        int customerType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the check-in date (DD/MM/YYYY): ");
        String startDateString = scanner.nextLine();

        System.out.print("Enter the check-out date (DD/MM/YYYY): ");
        String endDateString = scanner.nextLine();

        HotelDetails cheapestBestRatedHotel = hotelReservation.findCheapestBestRated(startDateString, endDateString, customerType);

        if (cheapestBestRatedHotel != null) {
            System.out.println("Cheapest Best Rated Hotel: " + cheapestBestRatedHotel.getHotelName());
            System.out.println("Rating: " + cheapestBestRatedHotel.getRating());
            System.out.println("Total Reward Cost: " +
                    hotelReservation.calculateTotalCost(startDateString, endDateString, cheapestBestRatedHotel, customerType));
        } else {
            System.out.println("No hotels available for the specified date range.");
        }

        scanner.close();
    }
}
