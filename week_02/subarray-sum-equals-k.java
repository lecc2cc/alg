class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] s = new int[nums.length + 1];
        s[0] = 0;
        s[1] = nums[0];
        for (int i=1; i <nums.length; i++) {
            s[i+1] = nums[i]  + s[i];
        }

        int ans = 0;
        for (int i=0; i < nums.length; i++) {
            for (int j=i; j < nums.length; j++) {
                if (k == (s[j+1] - s[i+1] + nums[i])) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
