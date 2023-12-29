package com.bridgelabz;

import  org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HotelReservationTest {
    @Test
    void testHotelCount() {
        HotelReservation lakewood = new HotelReservation();

        assertEquals(1, HotelReservation.getHotelCount());
    }
}