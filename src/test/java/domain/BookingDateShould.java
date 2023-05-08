package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookingDateShould {
  @Test
  public void create_a_booking_date_with_the_correct_format() {
    BookingDate bookingDate = new BookingDate("2023-01-01");

    assertEquals("2023-01-01", bookingDate.toString());
  }

  @Test
  public void throw_an_exception_when_the_date_format_is_invalid() {
    InvalidDateFormat invalidDateFormat = assertThrows(InvalidDateFormat.class, () -> {
        new BookingDate("2023/01-02");
    });
  }

  @ParameterizedTest
  @CsvSource({"2023-09-11, 2023-09-12, 1", "2023-09-11, 2023-09-13, 2", "2023-09-11, 2023-09-14, 3"})
  public void calculate_days_between_two_dates(String checkIn, String checkOut, int daysBetween) {
    BookingDate checkInDate = new BookingDate(checkIn);
    BookingDate checkOutDate = new BookingDate(checkOut);

    assertEquals(daysBetween, checkInDate.daysBetween(checkOutDate));
  }
}
