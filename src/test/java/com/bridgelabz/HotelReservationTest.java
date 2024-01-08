package com.bridgelabz;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

// This class contains @Test testFindCheapestBestRated().

class HotelReservationTest {

    /*  @Description: This class has the test cases for HotelReservation .
        @Parameters: -
        @Return: -
    */

    @Test
    void testFindCheapestBestRated() {
        HotelReservation hotelReservation = new HotelReservation();
        String startDate = "11/9/2020";
        String endDate = "12/9/2020";
        int regularCustomerType = 1; // 1 represents Regular customer type

        HotelDetails cheapestBestRatedHotel = hotelReservation.findCheapestBestRated(startDate, endDate, regularCustomerType);

        assertNotNull(cheapestBestRatedHotel);
        assertEquals("Lakewood", cheapestBestRatedHotel.getHotelName());
    }
}