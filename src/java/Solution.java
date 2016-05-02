public class Solution {

  public int solution(int[] A) {
    int maxSlice = 0;
    int a = 0;

    while (a + 1 < A.length) {

      int b = a + 1;
      while (b < A.length && A[a] == A[b]) {
        b++;
      }

      int c = b + 1;
      while (c < A.length && (A[a] == A[c] || A[b] == A[c])) {
        c++;
      }

      int slice = c - a;
      if (slice > maxSlice) {
        maxSlice = slice;
      }
      a++;
    }
    return maxSlice;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
//    int[] values = {1, 1, 0, 1, 1, 0, 0, 1, 2, 3};
    int[] values = {5, 4, 4, 5, 0, 12};
    int solution = s.solution(values);
    System.out.println("Solution: " + solution);
  }

}
