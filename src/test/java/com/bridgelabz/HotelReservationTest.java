package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HotelReservationTest {
    @Test
    void testCalculateLakewoodRewardCost() {
        HotelReservation hotelReservation = new HotelReservation();
        String startDate = "11/9/2020";
        String endDate = "12/9/2020";

        int lakewoodRewardCost = hotelReservation.calculateTotalCost(startDate, endDate, hotelReservation.lakewood);
        assertEquals(160, lakewoodRewardCost);
    }

    @Test
    void testCalculateBridgewoodRewardCost() {
        HotelReservation hotelReservation = new HotelReservation();
        String startDate = "11/9/2020";
        String endDate = "12/9/2020";

        int bridgewoodRewardCost = hotelReservation.calculateTotalCost(startDate, endDate, hotelReservation.bridgewood);
        assertEquals(160, bridgewoodRewardCost);
    }

    @Test
    void testCalculateRidgewoodRewardCost() {
        HotelReservation hotelReservation = new HotelReservation();
        String startDate = "11/9/2020";
        String endDate = "12/9/2020";

        int ridgewoodRewardCost = hotelReservation.calculateTotalCost(startDate, endDate, hotelReservation.ridgewood);
        assertEquals(140, ridgewoodRewardCost);
    }
}