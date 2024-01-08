package com.bridgelabz;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HotelReservationTest {
    @Test
    void testFindCheapestBestRated() {
        HotelReservation hotelReservation = new HotelReservation();
        String startDate = "11/9/2020";
        String endDate = "12/9/2020";

        HotelDetails cheapestBestRatedHotel = hotelReservation.findCheapestBestRated(startDate, endDate);

        Assert.assertNotNull(cheapestBestRatedHotel);
        assertEquals("Ridgewood", cheapestBestRatedHotel.getHotelName());
    }
}