package com.bridgelabz;

import  org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HotelReservationTest {
    @Test
    void testCalculateLakewoodCost() {
        HotelReservation hotelReservation = new HotelReservation();
        String startDate = "10/9/2020";
        String endDate = "11/9/2020";

        int lakewoodCost = hotelReservation.calculateTotalCost(startDate, endDate, hotelReservation.lakewood);
        assertEquals(220, lakewoodCost);
    }

    @Test
    void testCalculateBridgewoodCost() {
        HotelReservation hotelReservation = new HotelReservation();
        String startDate = "10/9/2020";
        String endDate = "11/9/2020";

        int bridgewoodCost = hotelReservation.calculateTotalCost(startDate, endDate, hotelReservation.bridgewood);
        assertEquals(320, bridgewoodCost);
    }

    @Test
    void testCalculateRidgewoodCost() {
        HotelReservation hotelReservation = new HotelReservation();
        String startDate = "10/9/2020";
        String endDate = "11/9/2020";

        int ridgewoodCost = hotelReservation.calculateTotalCost(startDate, endDate, hotelReservation.ridgewood);
        assertEquals(440, ridgewoodCost);
    }
}