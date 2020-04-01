package test.java.cli;

import org.junit.jupiter.api.Test;
import main.java.cli.DiskSimulation;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DiskSimulationTest {
  @Test
  void unexpectedEnumValueShouldShowError() {
    String[] args = {"notvalid", "1", "src/test/java/cli/testfile"};
    DiskSimulation.main(args);
    assertFalse(DiskSimulation.validArguments);

    args[0] = "1";
    DiskSimulation.main(args);
    assertFalse(DiskSimulation.validArguments);

    args[0] = "...";
    DiskSimulation.main(args);
    assertFalse(DiskSimulation.validArguments);
  }

  @Test
  void expectedEnumValueShouldBeAllowed() {
    String[] args = {"scan", "1", "src/test/java/cli/testfile"};
    DiskSimulation.main(args);
    assertTrue(DiskSimulation.validArguments);

    args[0] = "cscan";
    DiskSimulation.main(args);
    assertTrue(DiskSimulation.validArguments);

    args[0] = "fifo";
    DiskSimulation.main(args);
    assertTrue(DiskSimulation.validArguments);

    args[0] = "sstf";
    DiskSimulation.main(args);
    assertTrue(DiskSimulation.validArguments);
  }

  @Test
  void invalidQueueSizeShouldShowError() {
    String[] args = {"scan", "0", "src/test/java/cli/testfile"};
    DiskSimulation.main(args);
    assertFalse(DiskSimulation.validArguments);

    args[1] = "test";
    DiskSimulation.main(args);
    assertFalse(DiskSimulation.validArguments);

    args[1] = "-1";
    DiskSimulation.main(args);
    assertFalse(DiskSimulation.validArguments);
  }

  @Test
  void validQueueSizeShouldBeAllowed() {
    String[] args = {"scan", "1", "src/test/java/cli/testfile"};
    DiskSimulation.main(args);
    assertTrue(DiskSimulation.validArguments);

    args[1] = "1000000";
    DiskSimulation.main(args);
    assertTrue(DiskSimulation.validArguments);
  }

  @Test
  void invalidFileShouldShowError() {
    String[] args = {"scan", "1", "somerandomfile"};
    DiskSimulation.main(args);
    assertFalse(DiskSimulation.validArguments);

    args[2] = "00000";
    DiskSimulation.main(args);
    assertFalse(DiskSimulation.validArguments);
  }

  @Test
  void validFileShouldBeAllowed() {
    String[] args = {"scan", "1", "src/test/java/cli/testfile"};
    DiskSimulation.main(args);
    assertTrue(DiskSimulation.validArguments);
  }

  @Test
  void wrongNumberOfArgumentsShouldShowError() {
    String[] args = {"scan", "1", "src/test/java/cli/testfile", "toomanyarguments"};
    DiskSimulation.main(args);
    assertFalse(DiskSimulation.validArguments);

    args = new String[]{""};
    DiskSimulation.main(args);
    assertFalse(DiskSimulation.validArguments);

    args = new String[]{"oneargument"};
    DiskSimulation.main(args);
    assertFalse(DiskSimulation.validArguments);
  }
}
