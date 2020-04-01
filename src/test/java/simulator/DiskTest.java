package test.java.simulator;

import main.java.simulator.Disk;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiskTest {
  @Test
  void getCylinders() {
    Disk d1 = new Disk();
    assertEquals(1024, d1.getCylinders());
  }

  @Test
  void setCylinders() {
    Disk d1 = new Disk();
    d1.setCylinders(1);
    assertEquals(1, d1.getCylinders());
  }

  @Test
  void getSpeed() {
    Disk d1 = new Disk();
    assertEquals(7200, d1.getSpeed());
  }

  @Test
  void setSpeed() {
    Disk d1 = new Disk();
    d1.setSpeed(1);
    assertEquals(1, d1.getSpeed());
  }

  @Test
  void getStartDelay() {
    Disk d1 = new Disk();
    assertEquals(1, d1.getStartDelay());
  }

  @Test
  void setStartDelay() {
    Disk d1 = new Disk();
    d1.setStartDelay(10);
    assertEquals(10, d1.getStartDelay());
  }

  @Test
  void getStopDelay() {
    Disk d1 = new Disk();
    assertEquals(1, d1.getStopDelay());
  }

  @Test
  void setStopDelay() {
    Disk d1 = new Disk();
    d1.setStopDelay(10);
    assertEquals(10, d1.getStopDelay());
  }

  @Test
  void getTimeToTravel() {
    Disk d1 = new Disk();
    assertEquals(0.15, d1.getTimeToTravel());
  }

  @Test
  void setTimeToTravel() {
    Disk d1 = new Disk();
    d1.setTimeToTravel(0.5);
    assertEquals(0.5, d1.getTimeToTravel());
  }

  @Test
  void getLatency() {
    Disk d1 = new Disk();
    assertEquals(4.2, d1.getLatency());
  }

  @Test
  void setLatency() {
    Disk d1 = new Disk();
    d1.setLatency(0.5556);
    assertEquals(0.5556, d1.getLatency());
  }

  @Test
  void getSeekTime() {
    Disk d1 = new Disk();
    assertEquals(9.2, d1.getSeekTime(100, 120));
    assertEquals(159.8, d1.getSeekTime(0, 1024));
    assertEquals(d1.getLatency(), d1.getSeekTime(504, 504));
  }
}
