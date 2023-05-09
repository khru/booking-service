package application;

import domain.Booking;
import domain.BookingRepository;
import domain.InsuranceRepository;

public class InsureConfirmedBooking {
  private final InsuranceRepository insuranceRepository;
  private final BookingRepository bookingRepository;

  public InsureConfirmedBooking(InsuranceRepository insuranceRepository, BookingRepository bookingRepository) {
    this.bookingRepository = bookingRepository;
    this.insuranceRepository = insuranceRepository;
  }

  public void run(BookingDTO bookingPayload) {
    this.bookingRepository.save(bookingPayload);
    Booking booking = this.bookingRepository.findByReference(bookingPayload.reference());
    InsurableBookingDTO insurableBooking = booking.toInsurableBookingDTO();
    InsuranceDTO insuredBooking = this.insuranceRepository.insure(insurableBooking);
    this.insuranceRepository.save(insuredBooking);
  }
}
