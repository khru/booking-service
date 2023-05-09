package application;

import domain.Booking;
import domain.BookingRepository;
import domain.InsuranceRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class InsureConfirmedBookingTest {

  /**
   * @TODO: Replace mocks with InMemory representations
   * @TODO: InMemory representations will check the conversions of the DTOs to have the correct implementation
   * @TODO: InMemory representations will make me create the clients for the insurance (they'll be mocked)
   */

  @Test
	public void insure_a_booking_when_a_booking_is_sent() {
    BookingDTO bookingPayload = new BookingDTO("A83K1C", "confirmation", "2022-09-13", "2022-09-17", 3);
    Booking booking = new Booking(bookingPayload);
    InsurableBookingDTO insurableBooking = booking.toInsurableBookingDTO();
    InsuranceDTO insurance = new InsuranceDTO("A83K1C", "BI-281921");
    BookingRepository bookingRepository = mock(BookingRepository.class);
    InsuranceRepository insuranceRepository = mock(InsuranceRepository.class);

    when(bookingRepository.findByReference(bookingPayload.reference())).thenReturn(booking);
    when(insuranceRepository.insure(insurableBooking)).thenReturn(insurance);

    InsureConfirmedBooking insureBooking = new InsureConfirmedBooking(insuranceRepository, bookingRepository);
    insureBooking.run(bookingPayload);

    verify(bookingRepository).save(bookingPayload);
    verify(insuranceRepository).insure(insurableBooking);
    verify(insuranceRepository).save(insurance);
	}

}
