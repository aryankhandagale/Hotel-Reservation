package com.bridgelabz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the check-in date (DD/MM/YYYY): ");
        String startDateString = scanner.nextLine();

        System.out.print("Enter the check-out date (DD/MM/YYYY): ");
        String endDateString = scanner.nextLine();

        HotelReservation hotelReservation = new HotelReservation();
        HotelDetails cheapestBestRatedHotel = hotelReservation.findCheapestBestRated(startDateString, endDateString);

        if (cheapestBestRatedHotel != null) {
            System.out.println("Cheapest Best Rated Hotel: " + cheapestBestRatedHotel.getHotelName());
            System.out.println("Rating: " + cheapestBestRatedHotel.getRating());
            System.out.println("Total Reward Cost: " +
                    hotelReservation.calculateTotalCost(startDateString, endDateString, cheapestBestRatedHotel));
        } else {
            System.out.println("No hotels available for the specified date range.");
        }

        scanner.close();
    }
}
