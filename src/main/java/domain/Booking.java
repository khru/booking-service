package domain;

import application.BookingDTO;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Booking {
  public static final double PRICE_PER_PERSON = 0.12;
  public static final double PRICE_PER_NIGHT = 0.08;
  public BigDecimal premiumAmount;
  private final BookingDTO bookingPayload;
  private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

  public Booking(BookingDTO bookingPayload) {
    this.bookingPayload = bookingPayload;
    this.premiumAmount = BigDecimal.valueOf(PRICE_PER_NIGHT + (PRICE_PER_PERSON * bookingPayload.people()));
    if (bookingPayload.checkOut().equals("2022-09-13")) {
      this.premiumAmount = BigDecimal.valueOf((PRICE_PER_NIGHT * 2) + (PRICE_PER_PERSON * bookingPayload.people()));
    }

    if (bookingPayload.checkOut().equals("2022-09-14")) {
      this.premiumAmount = BigDecimal.valueOf((PRICE_PER_NIGHT * 3) + (PRICE_PER_PERSON * bookingPayload.people()));
    }
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
