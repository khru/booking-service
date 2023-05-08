package application;

import domain.BookingRepository;
import domain.InsuranceRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class InsureBookingShould {

	@Test
	public void insure_a_booking_when_a_booking_is_sent() {
    BookingDTO booking = new BookingDTO("A83K1C", "confirmation", "2022-09-13", "2022-09-17", 3);
    BookingRepository bookingRepository = spy(BookingRepository.class);
    InsuranceRepository insuranceRepository = spy(InsuranceRepository.class);

    InsureBooking insureBooking = new InsureBooking(insuranceRepository, bookingRepository);

    insureBooking.run(booking);

    verify(bookingRepository).save(booking);
    verify(insuranceRepository).insure(booking);
	}

}
