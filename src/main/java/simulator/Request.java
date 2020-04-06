package main.java.simulator;

/** Represents a cylinder request. */
public class Request implements Comparable<Request> {

  /** Cylinder number. */
  private Integer number;

  /** Time to get request. */
  private Double time;

  /**
   * Constructor for Request that takes in the cylinder number.
   *
   * @param number Cylinder number for request.
   */
  public Request(int number) {
    this.number = number;
    this.time = 0.0;
  }

  /**
   * Get cylinder number for request.
   *
   * @return Cylinder number.
   */
  public Integer getNumber() {
    return number;
  }

  /**
   * Set cylinder number for request.
   *
   * @param number Cylinder number.
   */
  public void setNumber(Integer number) {
    this.number = number;
  }

  /**
   * Get time for request.
   *
   * @return Time in milliseconds.
   */
  public Double getTime() {
    return time;
  }

  /**
   * Set time for request.
   *
   * @param time Time in milliseconds.
   */
  public void setTime(Double time) {
    this.time = time;
  }

  /**
   * Converts the request to a string.
   *
   * @return String representing a request.
   */
  @Override
  public String toString() {
    return "Request block: " + number + " Time: " + time;
  }

  @Override
  public int compareTo(Request o) {
    return this.getNumber().compareTo(o.getNumber());
  }
}
