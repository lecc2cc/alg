package rabinkarp;

import java.util.ArrayList;
import java.util.List;

public class StrStr {

    int strStr(String haystack, String needle) {
        int b = 131;
        int p = (int) 1e9 + 7;

        int n = haystack.length();
        int m = needle.length();

        long[] H = new long[n + 1];
        H[0] = 0;
        // a = 1 , b = 2, ... z = 26
        for (int i = 1; i <= n; i++) {
            long num = H[i - 1] * b + haystack.charAt(i - 1) - 'a' + 1;
            H[i] = (num % p);
        }

        long hNeedle = 0;
        long powBm = 1;

        for (char ch : needle.toCharArray()) {
            hNeedle = (hNeedle * b + ch - 'a' + 1) % p;
            powBm = (powBm * b) % p;
        }

        for (int l = 1; l <= n - m + 1; l++) {
            int r = l + m - 1;
            // s[l ... r] = nNeedle
            if ((((H[r] - H[l - 1] * powBm) % p + p) % p == hNeedle) &&
                    haystack.substring(l - 1, l - 1 + m).equals(needle)) {
                return l - 1;
            }

        }
        return -1;


    }
}
