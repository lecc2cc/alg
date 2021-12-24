class Solution {
    /**
     * 将上层的累加到下一层，每次取最小的
     *
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size()  == 0) {
            return triangle.get(0).get(0);
        }
        int n = triangle.size();
        
        // 每层的最小累加
        int[][] dp = new int[n][];
        dp[0] = new int[1];
        dp[0][0] = triangle.get(0).get(0);
        
    
        
        for (int i=1; i < n ; i++) {
            int m = triangle.get(i).size();
            // 新的一层
            dp[i] = new int[m];
            
            // 上一层的值累加本层(k,k+1)最小
            int lastN = dp[i-1].length;
            // 首尾
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            dp[i][m-1] = dp[i-1][lastN-1] + triangle.get(i).get(m-1);
            
            
            for (int j = 1; j < lastN; j++) {
                // 累加上层的，取最小
                int old1 = dp[i-1][j-1];
                int old2 = dp[i-1][j];
                
                int s = triangle.get(i).get(j);
                dp[i][j] = Math.min(old1+s, old2+s);
                
            }
        }
        
        // 最底层
        int ans = (int)10e9;
        for (int i=0; i < dp[n-1].length; i++) {
            ans = Math.min(ans, dp[n-1][i]);
        }
        return ans;
    }
}
