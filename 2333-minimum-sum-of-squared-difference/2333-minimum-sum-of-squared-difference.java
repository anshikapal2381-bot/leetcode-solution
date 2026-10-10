
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int[] freq = new int[100001];
        long total = 0;

        for (int i = 0; i < nums1.length; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            freq[d]++;
            total += d;
        }

        if (total <= k) {
            return 0;
        }

        for (int d = 100000; d > 0 && k > 0; d--) {
            if (freq[d] == 0) {
                continue;
            }

            long count = freq[d];

            if (count <= k) {
                freq[d - 1] += freq[d];
                freq[d] = 0;
                k -= count;
            } else {
                freq[d] -= (int) k;
                freq[d - 1] += (int) k;
                k = 0;
            }
        }

        long ans = 0;

        for (int d = 1; d <= 100000; d++) {
            ans += (long) d * d * freq[d];
        }

        return ans;
    }
}
