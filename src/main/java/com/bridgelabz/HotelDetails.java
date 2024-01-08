package com.bridgelabz;

// This class contains constructor and getters.

public class HotelDetails {
    /*  @Description: This class contains constructor and getters of instance variables for HotelReservation class.
        @Paramters: hotelName, regularWeekDayRate, regularWeekEndRate, rewardWeekDayRate, rewardWeekEndRate and rating
        @Return: hotelName, regularWeekDayRate, regularWeekEndRate, rewardWeekDayRate, rewardWeekEndRate and rating
    */
    private String hotelName;
    private int regularWeekDayRate, regularWeekEndRate, rewardWeekDayRate, rewardWeekEndRate, rating;

    public HotelDetails (String hotelName, int rating, int regularWeekDayRate, int regularWeekEndRate,
                         int rewardWeekDayRate, int rewardWeekEndRate) {
        this.hotelName = hotelName;
        this.rating = rating;
        this.regularWeekDayRate = regularWeekDayRate;
        this.regularWeekEndRate = regularWeekEndRate;
        this.rewardWeekDayRate = rewardWeekDayRate;
        this.rewardWeekEndRate = rewardWeekEndRate;
    }

    public String getHotelName() {
        return hotelName;
    }
    public int getRating() {
        return rating;
    }
    public int getRegularWeekDayRate() {
        return regularWeekDayRate;
    }
    public int getRegularWeekEndRate() {
        return regularWeekEndRate;
    }
    public int getRewardWeekDayRate() {
        return rewardWeekDayRate;
    }
    public int getRewardWeekEndRate() {
        return rewardWeekEndRate;
    }
}
