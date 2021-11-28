class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> countMap = new HashMap<>(50000);
        
        int maxCnt = 0;
        int ans = 50001;
        int min = 0;
        int arrSize = 0;

        for(int i = 0; i < nums.length; i++) {
            List<Integer> indexArr;
            int e = nums[i];
            if(countMap.containsKey(e)) {
                indexArr = countMap.get(e);
            } else {
                indexArr = new ArrayList<>();
                indexArr.add(0);
            }
            indexArr.add(i);
            countMap.put(e, indexArr);
            arrSize = indexArr.size();
            
            if ( arrSize>= maxCnt) {
                min = indexArr.get(arrSize - 1) - indexArr.get(1) + 1;
                if (arrSize > maxCnt) {
                    ans = min;
                } else {
                    ans = Math.min(ans, min);
                }
                
                maxCnt = arrSize;
                
            }
        }
        
        return ans;
    }
}
