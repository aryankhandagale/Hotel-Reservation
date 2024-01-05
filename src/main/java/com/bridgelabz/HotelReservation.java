package com.bridgelabz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class HotelReservation {
    HotelDetails lakewood = new HotelDetails("Lakewood", 3, 110, 90,
            80, 80);
    HotelDetails bridgewood = new HotelDetails("Bridgewood", 4, 150, 50,
            110, 50);
    HotelDetails ridgewood = new HotelDetails("Ridgewood", 5, 220, 150,
            100, 40);

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

    public HotelDetails findCheapest(String startDate, String endDate) {
        Map<HotelDetails, Integer> hotelCostMap = new HashMap<>();
        hotelCostMap.put(lakewood, calculateTotalCost(startDate, endDate, lakewood));
        hotelCostMap.put(bridgewood, calculateTotalCost(startDate, endDate, bridgewood));
        hotelCostMap.put(ridgewood, calculateTotalCost(startDate, endDate, ridgewood));

        int minCost = hotelCostMap.values().stream().min(Integer::compare).orElse(0);

        List<HotelDetails> cheapestHotels = new ArrayList<>();

        hotelCostMap.forEach((hotel, cost) -> {
            if (cost == minCost) {
                cheapestHotels.add(hotel);
            }
        });

        return getBestRating(cheapestHotels);
    }

    private HotelDetails getBestRating(List<HotelDetails> hotels) {
        return hotels.stream()
                .max(Comparator.comparingInt(HotelDetails::getRating))
                .orElse(null);
    }

    public HotelDetails findBestRated(String startDate, String endDate) {
        Map<HotelDetails, Integer> hotelRatingMap = new HashMap<>();
        hotelRatingMap.put(lakewood, calculateTotalCost(startDate, endDate, lakewood));
        hotelRatingMap.put(bridgewood, calculateTotalCost(startDate, endDate, bridgewood));
        hotelRatingMap.put(ridgewood, calculateTotalCost(startDate, endDate, ridgewood));

        int maxRating = hotelRatingMap.values().stream().max(Integer::compare).orElse(3);

        List<HotelDetails> bestRatedHotel = new ArrayList<>();

        hotelRatingMap.forEach((hotel, rating) -> {
            if (rating == maxRating) {
                bestRatedHotel.add(hotel);
            }
        });
        return getBestRating(bestRatedHotel);
    }
}