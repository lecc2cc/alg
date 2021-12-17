class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int num : weights) {
            left = Math.max(left, num);
            right += num;
        }

        while(left < right) {
            int mid = (left + right) / 2;
            if (validate(weights, days, mid)) {
                right = mid;
            } else {
                left = mid +1;
            }

            
        }
        return right;
    }
    
    private boolean validate(int[] nums, int m, int size) {
        int box = 0;
        int count = 1;
        for (int num : nums) {
            if (box + num <= size) {
                box += num;
            } else {
                count++;
                box = num;
            }
        }

        //System.out.println("day: " + m + " size: " + size + " count: " + count);
        return count <= m;
    }

}
