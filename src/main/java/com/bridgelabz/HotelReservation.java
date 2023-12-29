package com.bridgelabz;

class HotelDetails {
    private String hotelName;
    private int weekDayRate;

    public HotelDetails (String hotelName, int weekDayRate) {
        this.hotelName = hotelName;
        this.weekDayRate = weekDayRate;
    }

    public String getHotelName() {
        return hotelName;
    }
    public int getWeekDayRate() {
        return weekDayRate;
    }

    public void printHotelDetails() {
        System.out.println("Hotel Name: " + hotelName);
        System.out.println("Weekday Rate: $" + weekDayRate);
    }
}

public class HotelReservation {
    private static int hotelCount = 0;
    HotelDetails lakewood = new HotelDetails("Lakewood", 110);

    public HotelReservation() {
        hotelCount++;
    }

    public static int getHotelCount() {
        return hotelCount;
    }

    public static void main(String[] args) {
        HotelReservation reservation = new HotelReservation();
        reservation.lakewood.printHotelDetails();
    }
}
