package lesson.arrays;

public class MoveZero {
    public void moveZeroes(int[] nums) {
        int k = 0;
        // 遍历
        for (int i = 0; i < nums.length; i++) {
            // 过滤
            // 保留非零的
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }
        // 将非零的重置为零
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
