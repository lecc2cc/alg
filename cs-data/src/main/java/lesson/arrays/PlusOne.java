package lesson.arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length];

        // 加一的进位
        int carryBit = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            // 是否产生进位
            if (carryBit + digits[i] >= 10) {
                result[i] = carryBit + digits[i] - 10;
            } else {
                result[i] = carryBit + digits[i];
                carryBit = 0;
            }
        }

        if (carryBit == 0) {
            return result;
        }
        // 产生进位
        // 需要移动
        // 或利用语言的特性整体移动
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        System.arraycopy(ans, 1, result, 0, digits.length);
        return ans;
    }
}
