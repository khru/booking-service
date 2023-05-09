package domain;

import application.BookingDTO;
import application.InsurableBookingDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingShould {

  @ParameterizedTest
  @CsvSource({"1, 0.2", "2, 0.32", "3, 0.44"})
  public void calculate_premium_amount_for_any_amount_of_people_with_1_night(int numberOfPeople, BigDecimal expectedAmount) {
    BookingDTO bookingPayload = new BookingDTO("A_RANDOM_REFERENCE", "A_RANDOM_ACTION", "2022-09-11", "2022-09-12", numberOfPeople);
    InsurableBookingDTO insurableBookingDTO = new Booking(bookingPayload).toInsurableBookingDTO();

    assertEquals(expectedAmount, insurableBookingDTO.premiumAmount());
  }

  @ParameterizedTest
  @CsvSource({"2022-09-11, 2022-09-13, 0.28", "2022-09-11, 2022-09-14, 0.36", "2022-09-11, 2022-09-15, 0.44"})
  public void calculate_premium_amount_1_person_with_several_nights(String checkIn, String checkOut, BigDecimal expectedAmount) {
    BookingDTO bookingPayload = new BookingDTO("A_RANDOM_REFERENCE", "A_RANDOM_ACTION", checkIn, checkOut, 1);
    InsurableBookingDTO insurableBookingDTO = new Booking(bookingPayload).toInsurableBookingDTO();
    assertEquals(expectedAmount, insurableBookingDTO.premiumAmount());
  }

  @Test
  public void convert_to_insurable_booking() {
    BookingDTO bookingPayload = new BookingDTO("A_RANDOM_REFERENCE", "A_RANDOM_ACTION", "2022-09-11", "2022-09-12", 1);

    assertEquals(new InsurableBookingDTO(
      "A_RANDOM_REFERENCE",
      "2022-09-11",
      "2022-09-12",
      1,
      BigDecimal.valueOf(0.2),
      "EUR",
      "FLEXIBLE_INSURED"
      ), new Booking(bookingPayload).toInsurableBookingDTO());
  }
}
