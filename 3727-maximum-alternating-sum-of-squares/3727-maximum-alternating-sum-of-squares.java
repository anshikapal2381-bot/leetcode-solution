
import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] squares = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(squares);

        int n = squares.length;
        int k = (n + 1) / 2;
        long ans = 0;

        for (int i = 0; i < n - k; i++) {
            ans -= squares[i];
        }

        for (int i = n - k; i < n; i++) {
            ans += squares[i];
        }

        return ans;
    }
}
