package com.bridgelabz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

// This class contains HotelReservation(), calculateTotalCost(), findCheapestBestRated(), getAvailableHotels() and findBestRated().

public class HotelReservation {
    private List<HotelDetails> hotels;

    /*  @Description: This class has the implementation of Hotel Reservation program which provides the
            best hotel based on price and rating between given dates.
        @Parameters: start date and end date.
        @Return: totalCost, availableHotels.stream(), hotels and availableHotels.stream().
    */

    public HotelReservation() {
        hotels = new ArrayList<>();
        hotels.add(new HotelDetails("Lakewood", 3, 110, 90, 80, 80));
        hotels.add(new HotelDetails("Bridgewood", 4, 150, 50, 110, 50));
        hotels.add(new HotelDetails("Ridgewood", 5, 220, 150, 100, 40));
    }

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
                int dayOfWeek = startCalendar.get(Calendar.DAY_OF_WEEK);
                int rate = (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY)
                        ? hotel.getRewardWeekEndRate() : hotel.getRewardWeekDayRate();
                totalCost += rate;

                startCalendar.add(Calendar.DAY_OF_MONTH, 1);
            }
            return totalCost;
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter dates in DD/MM/YYYY format");
            return -1;
        }
    }

    public HotelDetails findCheapestBestRated(String startDate, String endDate) {
        List<HotelDetails> availableHotels = getAvailableHotels(startDate, endDate);
        return availableHotels.stream()
                .min(Comparator.comparingInt(hotel -> calculateTotalCost(startDate, endDate, hotel)))
                .orElse(null);
    }

    private List<HotelDetails> getAvailableHotels(String startDate, String endDate) {
        return hotels;
    }

    public HotelDetails findBestRated(String startDate, String endDate) {
        List<HotelDetails> availableHotels = getAvailableHotels(startDate, endDate);
        return availableHotels.stream()
                .max(Comparator.comparingInt(HotelDetails::getRating))
                .orElse(null);
    }
}