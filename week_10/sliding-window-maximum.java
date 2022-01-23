class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList();
        
        MyComparator myComparator = new MyComparator();
        Queue<Pair> q = new PriorityQueue<Pair>(myComparator);
        
        
        for (int i=0; i < nums.length; i++) {
            while (!q.isEmpty() && q.peek().getRank() <= i - k) q.poll();
            q.offer(new Pair(nums[i], i));
            if (i >= k - 1) ans.add(q.peek().getVal());
        }
        
        return ans.stream().mapToInt(i->i).toArray();
    }
    
    
    class MyComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair a, Pair b) {
            return  (a.getVal() - b.getVal()) * -1;
        }
    }
    
    class Pair {
        int val;
        int rank;
        
        Pair(int val, int rank) {
            this.val = val;
            this.rank = rank;
        }
        
        public int getVal() {
            return val;
        }
        public int getRank() {
            return rank;
        }
        
    }
}
