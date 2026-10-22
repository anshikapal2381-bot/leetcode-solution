class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 1; i < n; i++) {
            int prev = (zero + i - 1) % n;
            int curr = (zero + i) % n;
            if (nums[curr] != nums[prev] + 1) {
                increasing = false;
            }
            int prevRev = (zero - i + 1 + n) % n;
            int currRev = (zero - i + n) % n;
            if (nums[currRev] != nums[prevRev] + 1) {
                decreasing = false;
            }
        }
        int ans = Integer.MAX_VALUE;
        if (increasing) {
            ans = Math.min(ans, zero);
            ans = Math.min(ans, n - zero + 2);
        }
        if (decreasing) {
            ans = Math.min(ans, zero + 2);
            ans = Math.min(ans, n - zero);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
