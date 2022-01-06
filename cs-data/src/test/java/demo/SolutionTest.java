package demo;

import java.util.Arrays;

public class SolutionTest {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        if (n <= 0) {
            return true;
        }

        int[] dp = new int[nums.length];
        dp[0] = 0;
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],nums[i-1])-1;
            if (dp[i]<0) {
                return false;
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[nums.length-1]>=0;
    }

    public static int numSquares(int n) {
        int m = 1;
        for (int i=1; m*m < n; m +=1) {
        }
        System.out.println(m );

        int[] sq = new int[m+1];
        sq[0] = 0;
        for (int i=1; i <= m; i++) {
            sq[i] = i*i;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        int inf = (int)10e9;
        for (int i=1; i<=n; i++) {
            dp[i] = inf;
            for (int j=0; j < sq.length; j++) {
                //System.out.println("choose " + i + " " + sq[j]);
                if (sq[j] > 0 && i >= sq[j]) {
                    dp[i] = Math.min(dp[i], dp[i - sq[j]] + 1);

                    //System.out.println("dp " + i + " " + dp[i]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(sq));

        return (int)dp[n];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,5, 4, 7};
        nums = new int[]{2, 2, 2, 2, 2 };
        System.out.println(findNumberOfLIS(nums));

        System.out.println("----------");
        int[] arr = new int[]{2,3,1,1,4};
        //arr = new int[]{1,0,1,0};
        System.out.println(canJump(arr));

        //System.out.println(numSquares(25));

    }

    public static int findNumberOfLIS(int[] nums) {
        // 元素长度的数组个数
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            int k = 1;
            for (int j=0; j < i; j++) {
                if (nums[j] < num) {
                    if (j == 0 || nums[j-1] < nums[j]) {
                        k++;
                    }
                } else {
                    dp[k] += 1;
                    k = 1;
                }
            }
            dp[k] += 1;
        }
        System.out.println(Arrays.toString(dp));


        // 元素长度的数组个数
        for (int i = dp.length -1; i >0; i--) {
            if (dp[i] > 0) {
                return dp[i];
            }
        }

        return 0;

    }
}
