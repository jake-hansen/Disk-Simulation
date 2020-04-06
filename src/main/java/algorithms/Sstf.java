package main.java.algorithms;

import java.util.LinkedList;
import main.java.simulator.Request;

/**
 * Represents the SSTF algorithm.
 */
public class Sstf extends Algorithm {

  /** Default constructor sets algorithm's name. */
  public Sstf() {
    this.name = "SSTF";
  }

  /**
   * Sorts the given request queue using the SSTF strategy. SSTF strategy brings the request that is
   * closest to the disk head to the front of the queue.
   *
   * @param queue Queue to sort.
   * @param currentHeadPosition Current position of the disk's head.
   * @return Sorted queue using SSTF strategy.
   */
  @Override
  public LinkedList<Request> sort(LinkedList<Request> queue, int currentHeadPosition) {
    // Initialize lowest range to first request in queue's range
    int lowestRange;
    Request lowestRangeRequest;

    if (!queue.isEmpty()) {
      lowestRange = Math.abs(queue.peek().getNumber() - currentHeadPosition);
      lowestRangeRequest = queue.peek();

      // Loop through queue to find request closest to head
      for (Request r : queue) {
        int currentRange = Math.abs(r.getNumber() - currentHeadPosition);
        if (currentRange < lowestRange) {
          lowestRange = currentRange;
          lowestRangeRequest = r;
        }
      }

      // Move selected request to front of list
      queue.remove(lowestRangeRequest);
      queue.offerFirst(lowestRangeRequest);
    }

    return queue;
  }
}
