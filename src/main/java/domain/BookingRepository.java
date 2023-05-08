package domain;

import application.BookingDTO;

public interface BookingRepository {
  void save(BookingDTO booking);

  Booking findByReference(String id);
}
