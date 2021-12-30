class Solution {
    public int numSquares(int n) {
        int m = 1;
        for (; m*m <= n; m++) {
        }

        // 平方数
        int[] sq = new int[m+1];
        sq[0] = 0;
        for (int i=1; i <= m; i++) {
            sq[i] = i*i;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        int inf = (int)10e9;
        // 阶段
        for (int i=1; i<=n; i++) {
            dp[i] = inf;
            
            for (int j=0; j < sq.length; j++) {
                if (sq[j] > 0 && i >= sq[j]) {
                    dp[i] = Math.min(dp[i], dp[i - sq[j]] + 1);
                }
            }
        }
        

        return dp[n];
    }
}
