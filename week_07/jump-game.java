class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return true;
        }

        int[] dp = new int[nums.length];
        dp[0] = 0;
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],nums[i-1])-1;
            if (dp[i]<0) {
                return false;
            }
        }

        //System.out.println(Arrays.toString(dp));
        return dp[nums.length-1]>=0;
    }
}
