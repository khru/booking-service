package domain;

import application.InsurableBookingDTO;
import application.InsuranceDTO;

public interface InsuranceRepository {
  InsuranceDTO insure(InsurableBookingDTO booking);

  void save(InsuranceDTO insurance);
}
