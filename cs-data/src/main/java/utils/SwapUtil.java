package utils;

public class SwapUtil {
    /**
     * 泛型交换
     *
     * @param arr 数组
     * @param i   交换下标
     * @param j   交换下标
     * @param <T> 泛型
     */
    public static <T> void swap(T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * 数组交换
     *
     * @param arr 数组
     * @param i 下标
     * @param j 下标
     */
    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void swap(long[] arr, int i, int j) {
        long t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static boolean less(int a, int b) {
        return a < b;
    }

    public static boolean great(int a, int b) {
        return a > b;
    }
}
