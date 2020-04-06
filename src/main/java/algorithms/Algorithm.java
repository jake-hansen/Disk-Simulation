package main.java.algorithms;

import java.util.LinkedList;
import main.java.simulator.Request;

public abstract class Algorithm {

  /** Name of algorithm. */
  String name;

  /**
   * Get name of algorithm.
   *
   * @return Name of algorithm.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Sorts the given queue according to an algorithm.
   * @param queue Queue to sort.
   * @param currentHeadPosition Current position of disk's head.
   * @return Sorted queue according to the algorithm.
   */
  public abstract LinkedList<Request> sort(LinkedList<Request> queue, int currentHeadPosition);
}
