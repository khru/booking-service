package domain;

import application.BookingDTO;

public interface InsuranceRepository {
  void insure(BookingDTO booking);
}
