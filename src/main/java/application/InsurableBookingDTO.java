package application;


import domain.Booking;

import java.math.BigDecimal;

public record InsurableBookingDTO(String reference, String checkIn, String checkOut, int people, BigDecimal premiumAmount, String currency, String productName) {
}
