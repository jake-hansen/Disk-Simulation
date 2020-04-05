package main.java.algorithms;

import main.java.simulator.Request;

import java.util.LinkedList;

public abstract class Algorithm {

  /** Name of algorithm. */
  String name;

  public abstract LinkedList<Request> sort(LinkedList<Request> queue, Integer currentHeadPosition);
}
