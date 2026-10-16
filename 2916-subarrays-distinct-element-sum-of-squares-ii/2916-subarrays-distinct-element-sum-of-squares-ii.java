class Solution {
    static final long MOD = 1000000007L;

    int[] last;
    long[] sum, square, lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;

        last = new int[100001];
        Arrays.fill(last, -1);

        sum = new long[4 * n];
        square = new long[4 * n];
        lazy = new long[4 * n];

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = last[nums[i]];

            update(1, 0, n - 1, prev + 1, i);

            ans = (ans + square[1]) % MOD;

            last[nums[i]] = i;
        }

        return (int) ans;
    }

    void push(int node, int l, int r) {
        if (lazy[node] == 0) return;

        long x = lazy[node];
        long len = r - l + 1;

        square[node] =
            (square[node] + 2 * x * sum[node] + x * x * len) % MOD;

        sum[node] = (sum[node] + x * len) % MOD;

        if (l != r) {
            lazy[node * 2] = (lazy[node * 2] + x) % MOD;
            lazy[node * 2 + 1] = (lazy[node * 2 + 1] + x) % MOD;
        }

        lazy[node] = 0;
    }

    void update(int node, int l, int r, int ql, int qr) {
        push(node, l, r);

        if (l > qr || r < ql) return;

        if (l >= ql && r <= qr) {
            lazy[node] = 1;
            push(node, l, r);
            return;
        }

        int mid = l + (r - l) / 2;

        update(node * 2, l, mid, ql, qr);
        update(node * 2 + 1, mid + 1, r, ql, qr);

        sum[node] =
            (sum[node * 2] + sum[node * 2 + 1]) % MOD;

        square[node] =
            (square[node * 2] + square[node * 2 + 1]) % MOD;
    }
}
