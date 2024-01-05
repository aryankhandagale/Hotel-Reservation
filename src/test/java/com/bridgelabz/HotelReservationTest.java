package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HotelReservationTest {
    @Test
    void testCalculateLakewoodCost() {
        HotelReservation hotelReservation = new HotelReservation();
        String startDate = "11/9/2020";
        String endDate = "12/9/2020";

        int lakewoodRating = hotelReservation.lakewood.getRating();
        assertEquals(3, lakewoodRating);
    }

    @Test
    void testCalculateBridgewoodCost() {
        HotelReservation hotelReservation = new HotelReservation();
        String startDate = "11/9/2020";
        String endDate = "12/9/2020";

        int bridgewoodRating = hotelReservation.bridgewood.getRating();
        assertEquals(4, bridgewoodRating);
    }

    @Test
    void testCalculateRidgewoodCost() {
        HotelReservation hotelReservation = new HotelReservation();
        String startDate = "11/9/2020";
        String endDate = "12/9/2020";

        int ridgewoodRating = hotelReservation.ridgewood.getRating();
        assertEquals(5, ridgewoodRating);
    }
}