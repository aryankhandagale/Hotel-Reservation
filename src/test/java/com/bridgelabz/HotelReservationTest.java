package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HotelReservationTest {
    @Test
    void testCalculateLakewoodCost() {
        HotelReservation hotelReservation = new HotelReservation();
        String startDate = "11/9/2020";
        String endDate = "12/9/2020";

        int lakewoodCost = hotelReservation.calculateTotalCost(startDate, endDate, hotelReservation.lakewood);
        assertEquals(200, lakewoodCost);
    }

    @Test
    void testCalculateBridgewoodCost() {
        HotelReservation hotelReservation = new HotelReservation();
        String startDate = "11/9/2020";
        String endDate = "12/9/2020";

        int bridgewoodCost = hotelReservation.calculateTotalCost(startDate, endDate, hotelReservation.bridgewood);
        assertEquals(200, bridgewoodCost);
    }

    @Test
    void testCalculateRidgewoodCost() {
        HotelReservation hotelReservation = new HotelReservation();
        String startDate = "11/9/2020";
        String endDate = "12/9/2020";

        int ridgewoodCost = hotelReservation.calculateTotalCost(startDate, endDate, hotelReservation.ridgewood);
        assertEquals(370, ridgewoodCost);
    }
}