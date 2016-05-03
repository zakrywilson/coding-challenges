import org.junit.*;

import java.io.*;
import java.util.*;

/** 
* SolutionIter Tester. 
* @author Zach Wilson
*/
public class SolutionIterTest {

  /** Target values for file1.txt */
  private static List<Integer> values1;

  /** Target values for file2.txt */
  private static List<Integer> values2;

  /** Target values for file3.txt */
  private static List<Integer> values3;

  /** Name of file1.txt */
  private static String file1;

  /** Name of file2.txt */
  private static String file2;

  /** Name of file3.txt */
  private static String file3;


  /**
   * Create files and lists of target values for each file.
   */
  @BeforeClass
  public static void before() {
    // Path to 'test-resources' directory
    final String directory = "." + File.separator + "test-resources" + File.separator;

    // Target values
    values1 = new ArrayList<>(Arrays.asList(10, -88, 4, 2));
    values2 = new ArrayList<>(Arrays.asList(7, 888888, 22899, -909090));
    values3 = new ArrayList<>(Arrays.asList(9, -4, 7484, 1223));

    // File names
    file1 = directory + "file1.txt";
    file2 = directory + "file2.txt";
    file3 = directory + "file3.txt";
  }

  /**
   * Method: SolutionIter(Reader inp)
   */
  @Test
  public void testConstructor() {
    testValues(values1, file1);
    testValues(values2, file2);
    testValues(values3, file3);
  }

  /**
   * Tests that the target Integer array matches that of the parsed Integer array.
   * @param values - the target values
   * @param filename - the name of the file that contains the parse data
   */
  private void testValues(List<Integer> values, String filename) {
    // Create a reader object for Solution
    try (BufferedReader reader = new BufferedReader(new FileReader(new File(filename)))) {
      // Create an instance of the class to be tested
      SolutionIter solutionIter = new SolutionIter(reader);

      // Create iterators: new values and old values
      Iterator<Integer> newValues = solutionIter.iterator();
      Iterator<Integer> oldValues = values.iterator();

      // For each target value, test against the parsed value
      while (oldValues.hasNext()) {
        // If the number of elements do not line up, fail
        if (!newValues.hasNext()) {
          Assert.fail("Missing parsed values.");
        }

        // Get next values for comparing
        Integer oldValue = oldValues.next();
        Integer newValue = newValues.next();

        // If values are not equal, fail
        if (!oldValue.equals(newValue)) {
          Assert.fail("Mismatch: Old=" + oldValue + ", New=" + newValue + ".");
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
      Assert.fail("Error in creating Reader object.");
    }
  }

  /**
  * Method: iterator()
  */
  @Test
  public void testIterator() {
  //TODO: Test goes here...
  }

}
