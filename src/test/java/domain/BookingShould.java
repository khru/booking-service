package domain;

import application.BookingDTO;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingShould {
  @Test
  public void calculate_premium_amount_for_1_person_with_1_night() {
    BookingDTO bookingPayload = new BookingDTO("A_RANDOM_REFERENCE", "A_RANDOM_ACTION", "2022-09-11", "2022-09-12", 1);

    assertEquals(new BigDecimal("0.2"), new Booking(bookingPayload).premiumAmount);
  }
}
