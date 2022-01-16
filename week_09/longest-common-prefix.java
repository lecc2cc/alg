class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 1) {
            return strs[0];
        }
        
        String str = "";
        int len=10000;
        for (int i=0; i < strs.length; i++) { 
            if (strs[i].length() < len) {
                len = strs[i].length();
                str = strs[i];
            }
        }
        
        if (len == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < len; i++) {
            char ch = str.charAt(i);
            boolean same = true;
            for (int j =0; j<strs.length; j++) {
                char other = (strs[j]).charAt(i);
                if (other != ch) {
                    same = false;
                    break;
                }
            }
            
            if (!same) {
                break;
            }
            sb.append(ch);
        }
        return sb.toString();
        
    }
}
