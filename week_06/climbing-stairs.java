class Solution {
    /**
     *     1         2
     *----|---------------
     *  0 | 0        0
     *    |
     *  1 | 1        0      1
     *    |
     *  2 | 1,1      2      2
     *    |
     *  3 | 1,1,1    2,1    3
     *    | 1,2     
     *    |
     *  4 | 1,1,1,1  2,1,1  5
     *    | 1,1,2    2,2
     *    | 1,2,1
     *
     */
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=n ;i ++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
