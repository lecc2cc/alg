class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> m = new HashMap<>(s.length());
        Map<Character, Character> m2 = new HashMap<>();
        
        for (int i=0;i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
            if (m.containsKey(ch1)) {
                char c = m.get(ch1);
                
                if (c != ch2) {
                    return false;
                }
            } else {
                if (m2.containsKey(ch2)) {
                    if (m2.get(ch2) != ch1) {
                        return false;
                    }
                }
                m.put(ch1, ch2);
                m2.put(ch2, ch1);
            }
        }
        //System.out.println(m);
        return true;
    }
}
