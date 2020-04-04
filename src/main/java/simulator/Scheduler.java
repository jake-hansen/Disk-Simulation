package main.java.simulator;

import java.util.LinkedList;
import main.java.algorithms.Algorithm;

/** Manages scheduling disk reads. */
public class Scheduler {

  /** Requests to schedule. */
  private LinkedList<Request> requests;

  /** Depth of scheduler queue. */
  private int queueDepth;

  /** Queue to use for requests. */
  private LinkedList<Request> queue;

  /** Total seek for every request in queue. */
  private Double queueTotalTime;

  /** Algorithm class to use. */
  private Algorithm algorithmClass;

  /** Cylinder to start disk on before first read. */
  public static final int START_CYLINDER = 0;

  /** Disk the scheduler is scheduling for. */
  private Disk disk;

  /**
   * Gets the total queue time.
   *
   * @return Time in milliseconds.
   */
  public Double getQueueTotalTime() {
    return queueTotalTime;
  }

  /**
   * Get request list this scheduler is using.
   *
   * @return LinkedList of requests.
   */
  public LinkedList<Request> getRequests() {
    return requests;
  }

  /**
   * Takes requests and queueDepth to make a new Scheduler instance.
   *
   * @param requests Requests for scheduler to use.
   * @param queueDepth Depth of queue for scheduler.
   * @param algorithm Algorithm to use.
   * @param disk Disk to use.
   */
  public Scheduler(LinkedList<Integer> requests, int queueDepth, Algorithm algorithm, Disk disk) {
    this.requests = new LinkedList<Request>();
    for (Integer i : requests) {
      this.requests.add(new Request(i));
    }
    this.queueTotalTime = 0.0;
    this.queueDepth = queueDepth;
    this.queue = new LinkedList<Request>();
    this.algorithmClass = algorithm;
    this.disk = disk;
  }

  /**
   * Fills the scheduler's queue with requests to max capacity according to queueDepth. Removes
   * requests added to queue from request list.
   *
   * @return Scheduler's queue after fill.
   */
  public LinkedList<Request> fillQueue() {
    int currentQueueSize = queue.size();
    int availableSpacesInQueue = queueDepth - currentQueueSize;

    for (int i = 0; i < availableSpacesInQueue; i++) {
      queue.add(requests.remove());
    }
    return queue;
  }

  /**
   * Simulates scheduling a read operation. Sorts the scheduler's queue based on the chosen
   * scheduling algorithm. Calculates the time to get the next request in the queue after sorting
   * based on the current position of the disk's head. After time has been calculated, removes
   * request from queue.
   *
   * @return Time to read request.
   */
  public Request read() {
    // Sort queue based on algorithm
    queue = algorithmClass.sort(queue);

    // Now that the queue is sorted, retrieve the next block
    Request requestToRetrieve = queue.remove();
    Double seekTime =
        disk.getSeekTime(disk.getCurrentHeadPosition(), requestToRetrieve.getNumber());

    requestToRetrieve.setTime(seekTime);
    queueTotalTime += seekTime;

    // Update the disk head position to block retrieved
    disk.setCurrentHeadPosition(requestToRetrieve.getNumber());

    return requestToRetrieve;
  }
}