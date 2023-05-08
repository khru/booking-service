package domain;

import application.BookingDTO;

import java.util.Objects;

public class Booking {
  private final BookingDTO bookingPayload;

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

  public Booking(BookingDTO bookingPayload) {
    this.bookingPayload = bookingPayload;
  }
}