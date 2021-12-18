package sorts;

import utils.Fmt;
import utils.SwapUtil;

/**
 * 排序算法2： 插入排序
 *
 * 在输入数据比较大的情况下，而且元素部分排好序，插入排序比选择排序要快。
 *
 * 当大体都是O(n^2)
 *
 */
public class Insertion {
    /**
     * 普通的比较交换实现插入排序
     * --
     * 1. 假设第一个已排好，i从1开始遍历
     * 2. j从i开始，倒序比较，如果后面的小于前面的，交换位置
     *
     * @param nums
     */
    public static void insert(int[] nums) {
        //  0   1  2  3  4  5
        // [10, 9, 8, 7, 6, 5]
        //      j=1
        //  9  10
        //         j=2
        //  9  8  10
        //  8  9  10
        //
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j - 1] > nums[j]) {
                    SwapUtil.swap(nums, j - 1, j);
                }
            }
        }
    }

    /**
     * 基于位置移动实现插入排序
     * --
     * 1. 找出最小元素放置在第一位，作为哨兵使用
     * 2. 从下标2开始，记录最新需要插入的值，然后内部循环做一个简单的移动赋值，而不是比较交换
     * 3. 当元素插入到正确的位置后就终止内部循环
     *
     * @param nums
     */
    public static void insert1(int[] nums) {
        // 先找出最小，保证第一个最小，即已排好序
        for (int i = nums.length - 1; i > 0; i--) {
            // 后面的小于前面， 交换位置
            if (SwapUtil.less(nums[i], nums[i - 1])) {
                SwapUtil.swap(nums, i - 1, i);
            }
        }

        // 下标零已排好序，假设下标1也排好，然后从下标2开始
        // 如果下标2小于下标1，则记录下标2的值，然后移动下标1到下标2
        // 将下标1赋值
        //
        // 模拟
        //  0   1  2  3  4  5
        // [10, 9, 8, 7, 6, 5]
        // 已排好的哨兵5
        //  5   10 9  8  7  6
        //         j=2,v=9
        //  5   10 10
        //      赋值9
        //  5   9  10
        //            j=3,v=8
        //  5   9  10  10
        //  5   赋值8
        //  5   8   9  10
        for (int i = 2; i < nums.length; i++) {
            int j = i;
            // 记录当前需求排序的值，用于移动到适当位置的赋值
            int v = nums[i];
            // 倒序移动，如果比当前值还小，移动到后面一位
            while (SwapUtil.less(v, nums[j - 1])) {
                nums[j] = nums[j - 1];
                j--;
            }
            // 当前值插入
            nums[j] = v;
        }
    }
}
