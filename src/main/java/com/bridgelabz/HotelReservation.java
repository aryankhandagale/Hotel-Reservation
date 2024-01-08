package com.bridgelabz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

// This class contains HotelReservation(), calculateTotalCost(), findCheapestBestRated(), getAvailableHotels() and findBestRated().

public class HotelReservation {
    private List<HotelDetails> hotels;

    public HotelReservation() {
        hotels = Arrays.asList(
                new HotelDetails("Lakewood", 3, 110, 90, 80, 80),
                new HotelDetails("Bridgewood", 4, 150, 50, 110, 50),
                new HotelDetails("Ridgewood", 5, 220, 150, 100, 40)
        );
    }

    public int calculateTotalCost(String startDateString, String endDateString, HotelDetails hotel, int customerType) {
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
                int rate = 0;

                switch (customerType) {
                    case 1: // Regular
                        rate = (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY)
                                ? hotel.getRegularWeekEndRate() : hotel.getRegularWeekDayRate();
                        break;
                    case 2: // Reward
                        rate = (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY)
                                ? hotel.getRewardWeekEndRate() : hotel.getRewardWeekDayRate();
                        break;
                    default:
                        System.out.println("Invalid customer type. Please choose 1 for Regular or 2 for Reward.");
                        return -1;
                }

                totalCost += rate;
                startCalendar.add(Calendar.DAY_OF_MONTH, 1);
            }

            return totalCost;
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter dates in DD/MM/YYYY format");
            return -1;
        }
    }

    public HotelDetails findCheapestBestRated(String startDate, String endDate, int customerType) {
        List<HotelDetails> availableHotels = getAvailableHotels(startDate, endDate);
        return availableHotels.stream()
                .min(Comparator.comparingInt(hotel -> calculateTotalCost(startDate, endDate, hotel, customerType)))
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