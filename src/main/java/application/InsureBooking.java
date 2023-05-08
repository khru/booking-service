package application;

import domain.Booking;
import domain.BookingRepository;
import domain.InsuranceRepository;

public class InsureBooking {
  private final InsuranceRepository insuranceRepository;
  private final BookingRepository bookingRepository;

  public InsureBooking(InsuranceRepository insuranceRepository, BookingRepository bookingRepository) {
    this.bookingRepository = bookingRepository;
    this.insuranceRepository = insuranceRepository;
  }

  public void run(BookingDTO bookingPayload) {
    this.bookingRepository.save(bookingPayload);
    Booking booking = this.bookingRepository.findByReference(bookingPayload.reference());
    InsurableBookingDTO insurableBooking = new InsurableBookingDTO(booking);
    InsuranceDTO insuredBooking = this.insuranceRepository.insure(insurableBooking);
    this.insuranceRepository.save(insuredBooking);
  }
}
