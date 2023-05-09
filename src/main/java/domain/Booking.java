package domain;

import application.BookingDTO;
import application.InsurableBookingDTO;

import java.math.BigDecimal;

public class Booking {
  private static final double PRICE_PER_PERSON = 0.12;
  private static final double PRICE_PER_NIGHT = 0.08;
  public static final String CURRENCY = "EUR";
  public static final String PRODUCT_NAME = "FLEXIBLE_INSURED";
  private final BookingDTO bookingPayload;
  private BigDecimal premiumAmount;


  public Booking(BookingDTO bookingPayload) {
    this.bookingPayload = bookingPayload;
    BookingDate checkInDate = new BookingDate(this.bookingPayload.checkIn());
    BookingDate checkOutDate = new BookingDate(this.bookingPayload.checkOut());
    long daysOfStay = checkInDate.daysBetween(checkOutDate);
    this.premiumAmount = BigDecimal.valueOf((PRICE_PER_NIGHT * daysOfStay) + (PRICE_PER_PERSON * bookingPayload.people()));
  }

  public InsurableBookingDTO toInsurableBookingDTO() {
    return new InsurableBookingDTO(bookingPayload.reference(), bookingPayload.checkIn(), bookingPayload.checkOut(), bookingPayload.people(), premiumAmount, CURRENCY, PRODUCT_NAME);
  }
}
