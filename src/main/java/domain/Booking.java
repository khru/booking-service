package domain;

import application.BookingDTO;

import java.math.BigDecimal;
import java.util.Objects;

public class Booking {
  public BigDecimal premiumAmount;
  private final BookingDTO bookingPayload;

  public Booking(BookingDTO bookingPayload) {
    this.bookingPayload = bookingPayload;
    this.calculatePremiumAmount();
  }

  private void calculatePremiumAmount() {
    this.premiumAmount = BigDecimal.valueOf(0.08 + 0.12);
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
