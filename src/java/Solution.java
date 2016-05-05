/**
 * Solution.
 * @author Zach Wilson
 */
public class Solution {

  /**
   * Finds the largest bi-valued slice.
   *   a: The pointer that will traverse the array only once.
   *   b: The pointer that will be at least 1 index ahead of 'a' at all times
   *      and must always be a different value than the element at 'a'.
   *   c: The seeking pointer that will find the values ahead of 'a' and 'b',
   *      meaning that after two unique values are found, 'c' will find other
   *      values that are equal to either 'a' or 'b'.
   * @param A - the array to have it's largest bi-value found
   * @return the largest bi-valued slice
   */
  public int solution(int[] A) {
    int maxSlice = 0; // The max slice to be returned
    int a = 0;        // The first pointer (a cannot equal b)
    int b;            // The second pointer (b cannot equal a)
    int c;            // The third pointer (must equal a or b)

    // Iterate from 0 to n-1 elements
    while (a + 1 < A.length) {

      // Find value that is different than value at 'a'
      b = a + 1;
      while (b < A.length && A[a] == A[b]) {
        b++;
      }

      // Keep traversing array until value is found that is not equal to 'a' or 'b'
      c = b + 1;
      while (c < A.length && (A[a] == A[c] || A[b] == A[c])) {
        c++;
      }

      // If new slice is greater than maxSlice, replace maxSlice with new slice
      int slice = c - a;
      if (slice > maxSlice) {
        maxSlice = slice;
      }
      a = b;
    }
    return maxSlice;
  }

}
