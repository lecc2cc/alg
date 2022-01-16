class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        for (int i=0; i < map.length; i++) {
            map[i] = -1;
        }
        
        int maxLen = (int)1e9;
        
        for (int i=0; i< s.length();i++) {
            int ch = s.charAt(i) - 97;
            
            int index = map[ch];
            
            
            
            if (index == -1) {
                map[ch] = i;
            } else {
                map[ch] = maxLen;
            }
        }
       
        
        for (int i=0; i< s.length();i++) {
            int ch = s.charAt(i) - 97;
            if (map[ch] != maxLen) {
                return map[ch];
            }
        }
        
        return -1;
    }
}
