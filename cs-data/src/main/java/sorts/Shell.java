package sorts;

import utils.SwapUtil;

public class Shell {
    /**
     * 希尔排序 (局部有序的优化)
     * __
     * 希尔排序是插入排序的优化，在局部有序情况下，每次在相对少的移动操作和一次操作，
     * 从而缩短时间。
     * __
     * 插入排序是在相邻元素直接的移动和交换
     * __
     * 0. 增量分组
     * 1. 希尔排序将间隔gap个元素当成一个子数组，整体被划分为：
     * 0, 0+gap, 0+1*gap, ...
     * 1, 1+gap, 1+1*gap,
     * gap-1, gap-1 + gap, ...
     * 在每个子数组中进行插入排序
     * __
     * 2. 每次减少gap，这样就保证了减少一层，数组就相对有戏一点，直到gap=1
     *
     * @param nums
     */
    public void shell(int[] nums) {
        int gap;
        // 计算最大gap，从而减少gap
        // gap = 3*gap + 1
        // gap: 1, 4, 13, 40, ...
        for (gap = 1; gap <= (nums.length - 1) / 9; gap = 3 * gap + 1) {
            // empty
        }

        // 从大到小减少gap
        for (; gap > 0; gap /= 3) {
            // 每次gap开始
            // gap     - gap， 为0的增量数组
            // (gap+1) - gap， 为1的增量数组
            // ...
            // 当gap=0，即为普通的插入排序
            for (int i = gap; i < nums.length; i++) {
                int j = i;
                int v = nums[i];

                // 每次移动gap步长的增量数组
                while (j >= gap && SwapUtil.less(v, nums[j - gap])) {
                    nums[j] = nums[j - gap];
                    j -= gap;
                }
                nums[j] = v;
            }
        }
    }
}
