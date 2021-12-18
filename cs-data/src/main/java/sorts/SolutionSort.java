package sorts;

import utils.Fmt;

import java.util.Arrays;

public class SolutionSort {
    /**
     * 测试入口
     *
     * @param args
     */
    public static void main(String[] args) {
        // Selection
        // testSelect();

        //testInsert();
        testInsert1();
    }

    public static void testInsert1() {
        int[][] numsList = getExampleList();
        for (int[] nums : numsList) {
            Fmt.println("input: ", Arrays.toString(nums));
            Insertion.insert1(nums);
            Fmt.println("solution: ", Arrays.toString(nums));
        }
    }

    public static void testInsert() {
        int[][] numsList = getExampleList();
        for (int[] nums : numsList) {
            Fmt.println("input: ", Arrays.toString(nums));
            Insertion.insert(nums);
            Fmt.println("solution: ", Arrays.toString(nums));
        }
    }

    public static void testSelect() {
        int[][] numsList = getExampleList();
        for (int[] nums : numsList) {
            Fmt.println("input: ", Arrays.toString(nums));
            Selection.select(nums);
            Fmt.println("solution: ", Arrays.toString(nums));
        }
    }

    public static int[][] getExampleList() {
        return new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
                {1, 1, 1, 1, 2, 2, 2, 3, 3, 3},
                {9, 1, 2, 9, 1, 3, 2, 5, 4, 8},
                {2, 2, 3, 4, 1, 7, 8, 6, 9, 10},
                {944443, 293674, 572153, 600579, 499569, 984875, 763178, 29575, 44696, 207807, 138910},
                {3, 3, 1, 2},
                {369395, 265676, 858765, 420352, 366813, 401492, 303229, 659399, 354070, 64184, 411002, 797934},
                {24, 6, 3, 90, 10, 23, 89, 20, 100, 0},
                {22, 44, 5, 7, 10, 47, 82, 91},
        };
    }
}
