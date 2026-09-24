class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        int[] temp = new int[nums1.length];
        int k = 0;

        for (int i = 0; i < nums1.length; i++) {

            // Check if nums1[i] is present in nums2
            boolean found = false;

            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    found = true;
                    break;
                }
            }

            // Check duplicate
            boolean duplicate = false;

            for (int j = 0; j < k; j++) {
                if (temp[j] == nums1[i]) {
                    duplicate = true;
                    break;
                }
            }

            if (found && !duplicate) {
                temp[k] = nums1[i];
                k++;
            }
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = temp[i];
        }

        return result;
    }
}