package lesson.arrays;

public class RemoveDuplicate {

    public int removeDuplicates(int[] nums) {
        int k = 0;
        // 遍历
        for (int i = 0; i < nums.length; i++) {
            // 过滤，保留符合条件的
            // 第一个元素，或与前面一个不相同的
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
