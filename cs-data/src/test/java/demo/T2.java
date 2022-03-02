package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class T2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = 0;
        int[] inputs = getArray(bf.readLine());
        N = inputs[0];

        if (N <= 1) {
            echoResult(N);
            return;
        }

        int[] nums = getArray(bf.readLine());

        int[] suffixSum = new int[nums.length + 1];
        suffixSum[nums.length] = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + nums[i];
        }

        int ans = 0;
        int last = 0;
        for (int i = 0; i < nums.length; i++) {

            int s = nums[i];
            int j = i;
            while (j < nums.length && s < last) {
                s += nums[j + 1];
                j++;
            }
            int chose = nums[j];

            int left = suffixSum[j] - chose;

            if (left >= 0 && s >= last) {
                ans++;
                last = s;
                i = j;
            } else {
                break;
            }
        }


        echoResult(ans);


    }

    private static void echoResult(int ans) {
        System.out.println(ans);
    }

    private static int[] getArray(String text) {
        int[] a = new int[0];
        if (!text.contains(" ")) {
            a = new int[1];
            a[0] = Integer.parseInt(text);
        } else {
            String[] alpha = text.split(" ");
            a = new int[alpha.length];
            for (int i = 0; i < alpha.length; i++) {
                a[i] = Integer.parseInt(alpha[i]);
            }
        }
        return a;
    }

    // ----

    static boolean validate(int[] nums, int m, int size) {
        int box = 0;
        int count = 1;
        for (int num : nums) {
            if (box + num <= size) {
                box += num;
            } else {
                count++;
                box = num;
            }
        }
        return count <= m;
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            ans++;
            // 最低位的1清零
            n = n & (n - 1);
        }
        
        return ans;
    }
}
