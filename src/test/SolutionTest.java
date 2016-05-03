import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

/** 
* Solution Tester. 
* @author Zach Wilson
*/
public class SolutionTest {

  /** Solution object to be tested */
  private static Solution solution = new Solution();

  /**
  * Method: solution(int[] A)
  */
  @Test
  public void testSolution() {
    // Max slice = 4
    int[] A = new int[] {5, 4, 4, 5, 0, 12};
    if (solution.solution(A) != 4) {
      Assert.fail("Failed on array: " + Arrays.toString(A));
    }

    // Max slice = 5
    int[] B = new int[] {9, 1, 1, 1, 0, 1, 5, 2};
    if (solution.solution(B) != 5) {
      Assert.fail("Failed on array: " + Arrays.toString(B));
    }

    // Max slice = 2
    int[] C = new int[] {9, 1};
    if (solution.solution(C) != 2) {
      Assert.fail("Failed on array: " + Arrays.toString(C));
    }

    // Max slice = 0
    int[] D = new int[] {0};
    if (solution.solution(D) != 0) {
      Assert.fail("Failed on array: " + Arrays.toString(D));
    }
  }


} 
