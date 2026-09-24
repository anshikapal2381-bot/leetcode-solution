 class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int total = n * n;
        int repeated = -1;
        int missing = -1;
        for (int num = 1; num <= total; num++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (grid[i][j] == num) {
                        count++;
                    }
                }
            }
            if (count == 2) {
                repeated = num;
            }
            if (count == 0) {
                missing = num;
            }
        }
        return new int[]{repeated, missing};
    }
}
    