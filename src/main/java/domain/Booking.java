package domain;

import application.BookingDTO;
import application.InsurableBookingDTO;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;

public class Booking {
  private static final double PRICE_PER_PERSON = 0.12;
  private static final double PRICE_PER_NIGHT = 0.08;
  private final BookingDTO bookingPayload;
  public BigDecimal premiumAmount;


  public Booking(BookingDTO bookingPayload) {
    this.bookingPayload = bookingPayload;
    BookingDate checkInDate = new BookingDate(this.bookingPayload.checkIn());
    BookingDate checkOutDate = new BookingDate(this.bookingPayload.checkOut());
    long daysOfStay = checkInDate.daysBetween(checkOutDate);
    this.premiumAmount = BigDecimal.valueOf((PRICE_PER_NIGHT * daysOfStay) + (PRICE_PER_PERSON * bookingPayload.people()));
  }
}
