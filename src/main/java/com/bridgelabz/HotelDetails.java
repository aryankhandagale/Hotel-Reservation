package com.bridgelabz;

public class HotelDetails {
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
