package sorts;

import utils.SwapUtil;

public class Selection {
    /**
     * 选择排序
     * 1. 遍历数组，每次选择一个数字
     * 2. 从选取的数字下标后面一个开始，遍历数组
     * __ 2.1 找到小于选取的数字，记录该最小下标
     * __ 2.2 交换最小下标数字
     *
     * @param nums
     */
    public static void select(int[] nums) {
        // 从零开始
        for (int i = 0; i < nums.length; i++) {
            // 假设当前为最小的
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                // 比当前还小，交换下标
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            // 找到最小值的下标，交换值
            SwapUtil.swap(nums, i, min);
        }
    }
}
