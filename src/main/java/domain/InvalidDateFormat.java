package domain;


public class InvalidDateFormat extends RuntimeException {

  public InvalidDateFormat(Exception e) {
    super(e);
  }
}
