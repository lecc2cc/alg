class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        
        int m1 = min(nums, l, r);
        
        return nums[m1];
    }
    
   
    
    private int min(int[] nums, int left, int right) {
        while(left < right) {
            int mid = left + (right - left)/2;
            
            // [2,2,2,0,2,2]
            //  0 0 0 0 0 0
            // 剔除重复的
            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                right--;
                left++;
            } else if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return right;
    }
}
