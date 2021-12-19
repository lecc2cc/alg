package sorts;

import utils.SwapUtil;

public class Bubble {
    /**
     * 冒泡排序(大的冒出来排好)
     * --
     * 1. 倒序循环开始，缩短需要冒出来的数量
     * 2. 从0开始，到缩短数量哪里，逐一比较相邻元素，大的交换到后面
     *
     * @param nums
     */
    public void bub(int[] nums) {
        // 第一次需要交换到length -1，每次减少一个
        // 下次时前面length-1已排好，只需要到length-2即可
        for (int i = nums.length - 1; i > 0; i--) {
            // 当前一个和后面的比较
            // 大的交换到后面
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    SwapUtil.swap(nums, j, j + 1);
                }
            }
        }
    }

    /**
     * 冒泡排序(小的冒出来排好)
     * --
     * 1. 从零开始循环
     * 2. 倒序开始比较，到i+1，停止，后面的和前面的比较，小的交换
     *
     * @param nums
     */
    public void bub1(int[] nums) {
        // 从0开始遍历
        for (int i = 0; i < nums.length - 1; i++) {
            // 倒序比较小的，比较到i+1
            for (int j = nums.length - 1; j > i; j--) {
                // 小的交换
                if (nums[j - 1] > nums[j]) {
                    SwapUtil.swap(nums, j - 1, j);
                }
            }
        }
    }
}
