package sorts;

import utils.SwapUtil;

/**
 * 排序算法1: 选择排序
 *
 * 时间复杂度：O(n^2)
 */
public class Selection {
    /**
     * 选择排序(选取最小元素的下标)
     * --
     * 1. 遍历数组，每次选择一个数字
     * 2. 从选取的数字下标后面一个开始，遍历数组
     * __ 2.1 找到小于选取的数字，记录该最小下标
     * __ 2.2 交换最小下标数字
     *
     * @param nums
     */
    public static void select(int[] nums) {
        // 遍历模拟
        //  0  1  2  3  4  5  6
        // [9, 3, 2, 1, 5, 0, 7]
        //  min
        //     ->
        //                min
        //
        // 0 <-> 5
        //
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
