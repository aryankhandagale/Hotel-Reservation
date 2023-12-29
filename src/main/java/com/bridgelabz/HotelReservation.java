package com.bridgelabz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

class HotelDetails {
    private String hotelName;
    private int weekDayRate;

    public HotelDetails (String hotelName, int weekDayRate) {
        this.hotelName = hotelName;
        this.weekDayRate = weekDayRate;
    }

    public String getHotelName() {
        return hotelName;
    }
    public int getWeekDayRate() {
        return weekDayRate;
    }
}

public class HotelReservation {
    HotelDetails lakewood = new HotelDetails("Lakewood", 110);
    HotelDetails bridgewood = new HotelDetails("Bridgewood", 150);
    HotelDetails ridgewood = new HotelDetails("Ridgewood", 220);

    public int calculateTotalCost(String startDateString, String endDateString, HotelDetails hotel) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date startDate = dateFormat.parse(startDateString);
            Date endDate = dateFormat.parse(endDateString);

            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(startDate);

            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(endDate);

            int totalCost = 0;

            while (startCalendar.before(endCalendar) || startCalendar.equals(endCalendar)) {
                int rate = hotel.getWeekDayRate();
                totalCost += rate;

                startCalendar.add(Calendar.DAY_OF_MONTH, 1);
            }
            return totalCost;
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter dates in DD/MM/YYYY format");
            return -1;
        }
    }

    public HotelDetails findCheapest(String startDate, String endDate) {
        int lakewoodCost = calculateTotalCost(startDate, endDate, lakewood);
        int bridgewoodCost = calculateTotalCost(startDate, endDate, bridgewood);
        int ridgewoodCost = calculateTotalCost(startDate, endDate, ridgewood);

        if (lakewoodCost <= bridgewoodCost && lakewoodCost <= ridgewoodCost)
            return lakewood;
        else if (bridgewoodCost <= lakewoodCost && bridgewoodCost <= ridgewoodCost)
            return bridgewood;
        else
            return ridgewood;
    }
}

class Booking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the check-in date (DD/MM/YYYY): ");
        String startDateString = scanner.nextLine();

        System.out.print("Enter the check-out date (DD/MM/YYYY): ");
        String endDateString = scanner.nextLine();

        HotelReservation hotelReservation = new HotelReservation();
        HotelDetails cheapestHotel = hotelReservation.findCheapest(startDateString, endDateString);

        if (cheapestHotel != null) {
            System.out.println("Cheapest Hotel: " + cheapestHotel.getHotelName());
            System.out.println("Total Cost: " + hotelReservation.calculateTotalCost
                    (startDateString, endDateString, cheapestHotel));
        }
        scanner.close();
    }
}
