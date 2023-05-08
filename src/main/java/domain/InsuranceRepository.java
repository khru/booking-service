package domain;

import application.InsurableBookingDTO;

public interface InsuranceRepository {
  void insure(InsurableBookingDTO booking);
}
