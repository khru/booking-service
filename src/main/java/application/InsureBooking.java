package application;

import domain.BookingRepository;
import domain.InsuranceRepository;

public class InsureBooking {
  private final InsuranceRepository insuranceRepository;
  private final BookingRepository bookingRepository;

  public InsureBooking(InsuranceRepository insuranceRepository, BookingRepository bookingRepository) {
    this.insuranceRepository = insuranceRepository;
    this.bookingRepository = bookingRepository;
  }

  public void run(BookingDTO booking) {
    this.insuranceRepository.insure(booking);
    this.bookingRepository.save(booking);
  }
}
