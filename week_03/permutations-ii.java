class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        for(int i=0; i < nums.length; i++) {
            used[i] = false;
            if (!m.containsKey(String.valueOf(nums[i]))) {
                m.put(String.valueOf(nums[i]), false);
            } else {
                isFilter = true;
            }
        }
        
        n = nums.length;
        m = new HashMap<>();
        
        Arrays.sort(nums);
        recur(nums, 0);
        return ans;
    }
    
    private void recur(int[] nums, int pos) {
        if (pos == n) {
            List<Integer> t = new ArrayList<>(chosen);
            
        
            if (!same(t)) {
                ans.add(t);
            }
            
            return;
        }
        
        for(int i=0; i<nums.length; i++) {
            
            if (!used[i]) {
                used[i] = true;
                chosen.add(nums[i]);
                
                recur(nums, pos+1);
                
                if (chosen.size() > 0) { 
                    chosen.remove(chosen.size() - 1);
                }
                used[i] = false;
            }
        }
    }
    
    private boolean same(List<Integer> a) {
        if (!isFilter) {
            return false;
        }
        String i = "";
        for(int j=0; j < a.size();j++) {
            i +=  "," + String.valueOf(a.get(j));
        }
        if (m.containsKey(i)) {
            return true;
        }
        m.put(i, false);
        return false;
    }
    
    
    int n;
    private boolean[] used;
    List<Integer> chosen = new ArrayList();
    
    List<List<Integer>> ans = new ArrayList<>();
    boolean isFilter = false;
    Map<String, Boolean> m = new HashMap<>();
    
}
