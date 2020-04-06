package main.java.algorithms;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import main.java.simulator.Request;

/** Represents the CSCAN algorithm. */
public class Cscan extends Algorithm {

  /** Default constructor sets algorithm's name. */
  public Cscan() {
    this.name = "CSCAN";
  }

  /**
   * Sorts the given request queue using the CSCAN strategy. Does this by bringing requests that are
   * ahead of the disk's head position to the front of the queue, and moving requests that are below
   * the disk's head to the end of the queue.
   *
   * @param queue Queue to sort.
   * @param currentHeadPosition Current position of the disk's head.
   * @return Sorted queue using the CSCAN strategy.
   */
  @Override
  public LinkedList<Request> sort(LinkedList<Request> queue, int currentHeadPosition) {

    // Put requests that are ahead of the currentHeadPosition to the front of the queue
    // Temporarily remove any request that is below the currentHeadPosiiton
    LinkedList<Request> tempQueue = new LinkedList<>();

    Iterator<Request> itr = queue.iterator();
    while (itr.hasNext()) {
      Request req = itr.next();
      if (req.getNumber() < currentHeadPosition) {
        tempQueue.add(req);
        itr.remove();
      }
    }

    // Sort the remaining elements in the queue and tempQueue
    Collections.sort(queue);
    Collections.sort(tempQueue);

    // Append temporary requests to queue
    for (Request r : tempQueue) {
      queue.addLast(r);
    }

    return queue;
  }
}
