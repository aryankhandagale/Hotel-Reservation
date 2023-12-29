package com.bridgelabz;

import  org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HotelReservationTest {
    @Test
    void testCalculateTotalCost() {
        HotelReservation hotelReservation = new HotelReservation();
        String startDate = "10/9/2020";
        String endDate = "11/9/2020";

        int lakewoodCost = hotelReservation.calculateTotalCost(startDate, endDate, hotelReservation.lakewood);

        assertEquals(220, lakewoodCost);
    }
}