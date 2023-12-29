package com.bridgelabz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class HotelDetails {
    private String hotelName;
    private int weekDayRate, weekEndRate, rating;

    public HotelDetails (String hotelName, int rating, int weekDayRate, int weekEndRate) {
        this.hotelName = hotelName;
        this.rating = rating;
        this.weekDayRate = weekDayRate;
        this.weekEndRate = weekEndRate;
    }

    public String getHotelName() {
        return hotelName;
    }
    public int getRating() {
        return rating;
    }
    public int getWeekDayRate() {
        return weekDayRate;
    }
    public int getWeekEndRate() {
        return weekEndRate;
    }
}

public class HotelReservation {
    HotelDetails lakewood = new HotelDetails("Lakewood", 3, 110, 90);
    HotelDetails bridgewood = new HotelDetails("Bridgewood", 4, 150, 50);
    HotelDetails ridgewood = new HotelDetails("Ridgewood", 5, 220, 150);

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
                        ? hotel.getWeekEndRate() : hotel.getWeekDayRate();
                totalCost += rate;

                startCalendar.add(Calendar.DAY_OF_MONTH, 1);
            }
            return totalCost;
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter dates in DD/MM/YYYY format");
            return -1;
        }
    }

    public List<HotelDetails> findCheapest(String startDate, String endDate) {
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

        return cheapestHotels;
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
        List<HotelDetails> cheapestHotels = hotelReservation.findCheapest(startDateString, endDateString);

        if (!cheapestHotels.isEmpty()) {
            System.out.println("Cheapest Hotels:");
            for (HotelDetails cheapestHotel : cheapestHotels) {
                System.out.println("Hotel: " + cheapestHotel.getHotelName());
                System.out.println("Total Cost: " + hotelReservation.calculateTotalCost(startDateString, endDateString, cheapestHotel));
            }
        }

        scanner.close();
    }
}