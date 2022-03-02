package lesson.arrays;

public class MergeSorted {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;

        // 倒序遍历
        // 按两个数组总长度遍历
        for (int k = m + n - 1; k >= 0; k--) {
            // 过滤
            // 第二个数组出界了
            // 第二个数组没出界，且小于第一个数组对应的元素
            if (j < 0 || (i >= 0 && nums1[i] > nums2[j])) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
        }
    }
}
