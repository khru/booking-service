package domain;

import application.BookingDTO;

import java.math.BigDecimal;
import java.util.Objects;

public class Booking {
  public static final double PRICE_PER_PERSON = 0.12;
  public static final double PRICE_PER_NIGHT = 0.08;
  public BigDecimal premiumAmount;
  private final BookingDTO bookingPayload;

  public Booking(BookingDTO bookingPayload) {
    this.bookingPayload = bookingPayload;
    this.premiumAmount = BigDecimal.valueOf(PRICE_PER_NIGHT + (PRICE_PER_PERSON * bookingPayload.people()));
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Booking booking = (Booking) o;
    return Objects.equals(bookingPayload, booking.bookingPayload);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookingPayload);
  }
}
