package main.java.algorithms;

import java.util.LinkedList;
import main.java.simulator.Request;

public class Fifo extends Algorithm {

  /** Default constructor sets algorithm's name. */
  public Fifo() {
    this.name = "FIFO";
  }

  /**
   * Sorts the given request queue using the FIFO strategy. Requests are already read in from
   * request list in a FIFO scheme, so simply return the given queue with no modification.
   *
   * @param queue Queue to sort.
   * @return Sorted queue using FIFO strategy.
   */
  @Override
  public LinkedList<Request> sort(LinkedList<Request> queue) {
    // FIFO algorithm does not modify order of requests in queue
    return queue;
  }
}
