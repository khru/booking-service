package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class BookingDate {
  public static final String DATE_FORMAT = "yyyy-MM-dd";
  private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH);
  private final String dateValue;
  private Date date;

  public BookingDate(String date) {
    this.dateValue = date;
    this.fromDateString(date);
  }

  private Date date() {
    return this.date;
  }

  private void fromDateString(String date) {
    try {
      this.date = simpleDateFormat.parse(date);
    } catch (ParseException e) {
      throw new InvalidDateFormat(e);
    }
  }

  public long daysBetween(BookingDate otherBookingDate) {
    long diffInMillies = Math.abs(otherBookingDate.date().getTime() - this.date.getTime());
    return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
  }

  @Override
  public String toString() {
    return String.valueOf(this.dateValue);
  }
}
