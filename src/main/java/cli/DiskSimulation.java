package main.java.cli;

import java.io.File;

/** This class serves as the main entry point to the disk simulation program. */
public class DiskSimulation {

  /** Contains allowed algorithm types. */
  public enum ALGORITHMS {
    SCAN,
    CSCAN,
    FIFO,
    SSTF
  }

  /** Keeps track of if valid arguments are given. */
  public static boolean validArguments = true;

  /**
   * Entry point for Disk Simulation program.
   *
   * @param args Arguments passed to program.
   */
  public static void main(String[] args) {
    System.out.println(
        "######                      #####                                                      \n"
            + "#     # #  ####  #    #    #     # # #    # #    # #        ##   ##### #  ####  #    # \n"
            + "#     # # #      #   #     #       # ##  ## #    # #       #  #    #   # #    # ##   # \n"
            + "#     # #  ####  ####       #####  # # ## # #    # #      #    #   #   # #    # # #  # \n"
            + "#     # #      # #  #            # # #    # #    # #      ######   #   # #    # #  # # \n"
            + "#     # # #    # #   #     #     # # #    # #    # #      #    #   #   # #    # #   ## \n"
            + "######  #  ####  #    #     #####  # #    #  ####  ###### #    #   #   #  ####  #    # \n");

    System.out.println("Made by Jake Hansen. April 2020.");

    // Parse arguments. Assume arguments are all valid before parsing.
    validArguments = true;
    parseArguments(args);
  }

  /**
   * Validate given command line arguments. Valid command line arguments are ALGORITHM TYPE, QUEUE
   * SIZE, NAME OF INPUT FILE.
   *
   * @param args Arguments to parse.
   */
  private static void parseArguments(String[] args) {

    // If args is not empty, parse the arguments.
    if (args.length == 3) {

      // Parse ALGORITHM TYPE argument.
      ALGORITHMS alorithmType = null;
      try {
        alorithmType = ALGORITHMS.valueOf(args[0].toUpperCase());
      } catch (IllegalArgumentException iae) {
        System.err.println("Provided argument for 'algorithm' is not valid.");
        validArguments = false;
      }

      // Parse QUEUE SIZE argument.
      int queueSize = 0;
      try {
        queueSize = Integer.parseInt(args[1]);
        if (queueSize < 1) {
          throw new NumberFormatException();
        }
      } catch (NumberFormatException nfe) {
        System.err.println("Provided argument for 'queue size' is not valid.");
        validArguments = false;
      }

      // Parse NAME OF INPUT FILE argument
      // TODO: Need to add relative/absolute file functionality
      String inputFileName = null;
      inputFileName = args[2];
      File checkFile = new File(inputFileName);
      if (!checkFile.exists()) {
        System.err.println(
            "Provided argument for 'file name' is not valid. The file does not exist");
        validArguments = false;
      }

    } else {
      System.err.println("Wrong number of arguments were given.");
      validArguments = false;
    }
  }
}
