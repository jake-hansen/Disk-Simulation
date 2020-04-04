package main.java.simulator;

/** Represents a block request. */
public class Request {

  /** Cylinder number. */
  private int number;

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
   * @return Cylinder number.
   */
  public int getNumber() {
    return number;
  }

  /**
   * Set cylinder number for request.
   * @param number Cylinder number.
   */
  public void setNumber(int number) {
    this.number = number;
  }

  /**
   * Get time for request.
   * @return Time in milliseconds.
   */
  public Double getTime() {
    return time;
  }

  /**
   * Set time for request.
   * @param time Time in milliseconds.
   */
  public void setTime(Double time) {
    this.time = time;
  }
}
