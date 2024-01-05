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
        HotelDetails bestRatedHotels = hotelReservation.findCheapest(startDateString, endDateString);
        HotelDetails bestRating = hotelReservation.findBestRated(startDateString, endDateString);

        if (bestRating != null) {
            System.out.println("Hotel : " + bestRating.getHotelName());
            System.out.println("Total Reward Cost: " + hotelReservation.calculateTotalCost(startDateString, endDateString, bestRating));
        }

        scanner.close();
    }
}