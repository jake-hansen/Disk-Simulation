package main.java.simulator;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** Represents a single Disk. Provides all disk functionality. */
public class Disk {
  /** Default number of cylinders. */
  private static int DEFAULT_CYLINDERS = 1024;

  /** Default speed. */
  private static int DEFAULT_SPEED = 7200;

  /** Default head start delay. */
  private static int DEFAULT_START_DELAY = 1;

  /** Default head stop delay. */
  private static int DEFAULT_STOP_DELAY = 1;

  /** Default time to travel. */
  private static Double DEFAULT_TIME_TO_TRAVEL = 0.15;

  /** Default latency. */
  private static Double DEFAULT_LATENCY = 4.2;

  /** Number of cylinders. */
  private int cylinders;

  /** Speed in RPM. */
  private int speed;

  /** Head start delay in milliseconds. */
  private int startDelay;

  /** Head stop delay in milliseconds. */
  private int stopDelay;

  /** Time to travel in milliseconds. */
  private Double timeToTravel;

  /** Latency in milliseconds. */
  private Double latency;

  /**
   * Gets the number of cylinders of the Disk.
   *
   * @return Number of cylinders.
   */
  public int getCylinders() {
    return cylinders;
  }

  /**
   * Sets the number of cylinders for the Disk.
   *
   * @param cylinders Number of cylinders to set.
   */
  public void setCylinders(int cylinders) {
    this.cylinders = cylinders;
  }

  /**
   * Gets the speed of the Disk.
   *
   * @return Speed in RPMs.
   */
  public int getSpeed() {
    return speed;
  }

  /**
   * Sets the speed of the Disk.
   *
   * @param speed Speed in RPMs.
   */
  public void setSpeed(int speed) {
    this.speed = speed;
  }

  /**
   * Gets the start delay of the Disk.
   *
   * @return Start delay in milliseconds.
   */
  public int getStartDelay() {
    return startDelay;
  }

  /**
   * Sets the start delay of the Disk.
   *
   * @param startDelay Start delay in milliseconds.
   */
  public void setStartDelay(int startDelay) {
    this.startDelay = startDelay;
  }

  /**
   * Gets the stop delay of the Disk.
   *
   * @return Stop delay in milliseconds.
   */
  public int getStopDelay() {
    return stopDelay;
  }

  /**
   * Sets the stop delay of the Disk.
   *
   * @param stopDelay Stop delay in milliseconds.
   */
  public void setStopDelay(int stopDelay) {
    this.stopDelay = stopDelay;
  }

  /**
   * Gets the time to travel of the head.
   *
   * @return Time to travel of head in milliseconds.
   */
  public Double getTimeToTravel() {
    return timeToTravel;
  }

  /**
   * Sets the time to travel of the head.
   *
   * @param timeToTravel Time to travel of head in milliseconds.
   */
  public void setTimeToTravel(Double timeToTravel) {
    this.timeToTravel = timeToTravel;
  }

  /**
   * Gets the latency of the Disk.
   *
   * @return Latency in milliseconds.
   */
  public Double getLatency() {
    return latency;
  }

  /**
   * Sets the latency of the Disk.
   *
   * @param latency Latency in milliseconds.
   */
  public void setLatency(Double latency) {
    this.latency = latency;
  }

  /** Default constructor. Sets number of cylinders and speed to default values. */
  public Disk() {
    this.setCylinders(DEFAULT_CYLINDERS);
    this.setSpeed(DEFAULT_SPEED);
    this.setStartDelay(DEFAULT_START_DELAY);
    this.setStopDelay(DEFAULT_STOP_DELAY);
    this.setTimeToTravel(DEFAULT_TIME_TO_TRAVEL);
    this.setLatency(DEFAULT_LATENCY);
  }

  /**
   * Constructor that sets number of cylinders and speed to provided values.
   *
   * @param numberOfCylinders Number of cylinders.
   * @param speed Speed in RPMs.
   */
  public Disk(int numberOfCylinders, int speed) {
    this.setCylinders(numberOfCylinders);
    this.setSpeed(speed);
    this.setStartDelay(DEFAULT_START_DELAY);
    this.setStopDelay(DEFAULT_STOP_DELAY);
    this.setTimeToTravel(DEFAULT_TIME_TO_TRAVEL);
    this.setLatency(DEFAULT_LATENCY);
  }

  /**
   * Get distance between two cylinders.
   *
   * @param startCylinder Cylinder head starts on.
   * @param stopCylinder Cylinder head stops on.
   * @return Absolute value difference between start cylinder and stop cylinder.
   */
  private int getCylinderDistance(int startCylinder, int stopCylinder) {
    return Math.abs(startCylinder - stopCylinder);
  }

  /**
   * Get seek time for traveling between two cylinders.
   *
   * <p>The calculation is as follows: START_DELAY + DISTANCE * TIME TO TRAVEL + STOP DELAY +
   * LATENCY. If the start and stop cylinders are the same cylinder the seek time is only the
   * latency.
   *
   * @param startCylinder Cylinder head starts on.
   * @param stopCylinder Cylinder head stops on.
   * @return Time in milliseconds to seek between two cylinders rounded to 1 decimal place.
   */
  public Double getSeekTime(int startCylinder, int stopCylinder) {
    // Return only the latency if the start and stop cylinders are the same
    if (startCylinder == stopCylinder) {
      return getLatency();
    } else {
      double calculation =
          getStartDelay()
              + (getCylinderDistance(startCylinder, stopCylinder) * getTimeToTravel())
              + getStopDelay()
              + getLatency();

      BigDecimal round = BigDecimal.valueOf(calculation);
      round = round.setScale(1, RoundingMode.HALF_UP);
      return round.doubleValue();
    }
  }
}
