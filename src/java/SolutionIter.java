import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Reader;
import java.util.List;

/**
 * SolutionIter.
 * @author Zach Wilson
 */
class SolutionIter implements Iterable<Integer> {

  /** Array of Integers for iterating over */
  private List<Integer> values;

  /**
   * Constructor.
   * @param inp - reader whose Integers are to be parsed into iterable array.
   */
  public SolutionIter(Reader inp) {
    this.values = new ArrayList<>();
    parseIntegers(inp);
  }

  /**
   * Parses Integers in file and adds them to 'values' array.
   * @param inp - the reader input to be parsed
   */
  private void parseIntegers(Reader inp) {
    // Create a buffered reader with the reader object received
    try (BufferedReader reader = new BufferedReader(inp)) {
      String line;

      // For each line in the file, store integer if value is correct
      while ((line = reader.readLine()) != null) {
        // Remove whitespace
        line = line.trim();

        // If integer is valid, store in 'values' array
        try {
          values.add(BigInteger.valueOf(Long.parseLong(line)).intValueExact());
        } catch (RuntimeException e) {
          // Value was invalid... skip it and continue
        }
      } // End of loop
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * @return iterator for SolutionIter.
   */
  @Override
  public Iterator<Integer> iterator() {
    return values.iterator();
  }

}
