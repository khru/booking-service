package application;

import domain.Booking;
import domain.BookingRepository;
import domain.InsuranceRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class InsureBookingShould {

	@Test
	public void insure_a_booking_when_a_booking_is_sent() {
    BookingDTO bookingPayload = new BookingDTO("A83K1C", "confirmation", "2022-09-13", "2022-09-17", 3);
    Booking booking = new Booking(bookingPayload);
    InsurableBookingDTO insurableBooking = new InsurableBookingDTO(booking);
    BookingRepository bookingRepository = mock(BookingRepository.class);
    InsuranceRepository insuranceRepository = spy(InsuranceRepository.class);
    when(bookingRepository.findByReference(bookingPayload.reference())).thenReturn(booking);

    InsureBooking insureBooking = new InsureBooking(insuranceRepository, bookingRepository);

    insureBooking.run(bookingPayload);

    verify(bookingRepository).save(bookingPayload);
    verify(insuranceRepository).insure(insurableBooking);
	}

}
