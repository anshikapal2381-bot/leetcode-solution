class Solution {
    int m, n;
    char[][] grid;
    Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        // Path length must be even
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        // Starting character must be '('
        if (grid[0][0] != '(') {
            return false;
        }

        dp = new Boolean[m][n][m + n];

        return dfs(0, 0, 0);
    }

    boolean dfs(int r, int c, int balance) {

        if (r >= m || c >= n) {
            return false;
        }

        if (grid[r][c] == '(') {
            balance++;
        } else {
            balance--;
        }

        // Balance kabhi negative nahi hona chahiye
        if (balance < 0) {
            return false;
        }

        // Remaining cells bhi balance ko zero tak la sakne chahiye
        int remaining = (m - 1 - r) + (n - 1 - c);

        if (balance > remaining) {
            return false;
        }

        // Destination
        if (r == m - 1 && c == n - 1) {
            return balance == 0;
        }

        if (dp[r][c][balance] != null) {
            return dp[r][c][balance];
        }

        boolean ans =
            dfs(r + 1, c, balance) ||
            dfs(r, c + 1, balance);

        dp[r][c][balance] = ans;

        return ans;
    }
}