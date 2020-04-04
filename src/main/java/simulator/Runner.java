package main.java.simulator;

import main.java.algorithms.Algorithm;

import java.util.LinkedList;

public class Runner {

  /** Disk to use for simulation. */
  Disk disk;

  /** Scheduler to use for simulation. */
  Scheduler scheduler;

  public Runner(Disk disk, LinkedList<Integer> requests, int queueDepth, Algorithm algorithm) {
    this.disk = disk;
    this.scheduler = new Scheduler(requests, queueDepth, algorithm, disk);
  }

  /**
   * Simulates running multiple request reads. Starts by setting the disk's head to the specified
   * starting cylinder. Then, using the scheduler, fills the request queue and reads requests based
   * on the specified algorithm. Does this until there are no more request's in the scheduler's queue.
   *
   * @return Total time requests spent in queue in milliseconds.
   */
  public Double run() {

    // Start disk cylinder on scheduler's specified start cylinder
    disk.setCurrentHeadPosition(Scheduler.START_CYLINDER);

    // Process requests while they exist
    do {
      scheduler.fillQueue();
      scheduler.read();
    } while (!scheduler.getQueue().isEmpty());

    return scheduler.getQueueTotalTime();
  }
}
