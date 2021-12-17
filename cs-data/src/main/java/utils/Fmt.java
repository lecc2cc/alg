package utils;

import java.util.Arrays;

public class Fmt {
    /**
     * @param args 打印多个字符串
     */
    public static void println(Object... args) {
        for (Object arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println("");
    }

    /**
     * @param arr 打印数组
     */
    public static void println(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void println(String tips, int[] arr) {
        System.out.println(tips + " " + Arrays.toString(arr));
    }

    public static void print(Object obj) {
        System.out.print(obj);
    }

    public static void newLine() {
        System.out.println("");
    }
}
