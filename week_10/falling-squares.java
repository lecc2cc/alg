class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> xs = new ArrayList<>();
        for (int[] p : positions) {
            int a = p[0], b = a + p[1];
            xs.add(a * 2);
            xs.add(b * 2);
            xs.add(a + b);
        }
        // 排序并去重
        xs = unique(xs);
        
        SegTree segTree = new SegTree(xs.size());
        
        List<Integer> ans = new ArrayList<>();
        for (int[] p : positions) {
            int a = p[0], b = a + p[1];
            a = get(a * 2, xs);
            b = get(b * 2, xs);
            int h = segTree.query(1, a + 1, b - 1);
            segTree.update(1, a, b, h + p[1]);
            ans.add(segTree.query());
        }
        
        return ans;
        
    }
    private List<Integer> unique(List<Integer> list) {
        list.sort(Integer::compareTo);
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0 || list.get(j - 1) != list.get(i)) {
                list.set(j++, list.get(i));
            }
        }
        
        return list.subList(0, j);
    }
    
    private int get(int x, List<Integer> xs) {
        int l = 0, r = xs.size() - 1;
        while (l < r) {
            int m = l + r >> 1;
            if (xs.get(m) >= x) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
    
    class SegTree {
        
        // v是[l, r]区间的最大值，lazy是懒标记
        class Node {
            int l, r, v, lazy;
        
            public Node(int l, int r) {
                this.l = l;
                this.r = r;
            }
        }
    
        private Node[] tr;
    
        public SegTree(int size) {
            tr = new Node[size << 2];
            build(1, 0, size - 1);
        }
    
        private void pushup(int u) {
            tr[u].v = Math.max(tr[u << 1].v, tr[u << 1 | 1].v);
        }
    
    	
        private void pushdown(int u) {
            int c = tr[u].lazy;
            if (c != 0) {
                tr[u].lazy = 0;
                tr[u << 1].v = tr[u << 1 | 1].v = c;
                tr[u << 1].lazy = tr[u << 1 | 1].lazy = c;
            }
        }
    
        public void build(int u, int l, int r) {
            tr[u] = new Node(l, r);
            if (l == r) {
                return;
            }
        
            int mid = l + r >> 1;
            build(u << 1, l, mid);
            build(u << 1 | 1, mid + 1, r);
        }
    
        public void update(int u, int l, int r, int c) {
        	
            if (l <= tr[u].l && tr[u].r <= r) {
                tr[u].v = tr[u].lazy = c;
                return;
            }
        
        	
            pushdown(u);
            int mid = tr[u].l + tr[u].r >> 1;
            if (l <= mid) {
                update(u << 1, l, r, c);
            }
            if (mid + 1 <= r) {
                update(u << 1 | 1, l, r, c);
            }
            
            pushup(u);
        }
    
        public int query(int u, int l, int r) {
            if (l <= tr[u].l && tr[u].r <= r) {
                return tr[u].v;
            }

            pushdown(u);
            int res = 0, mid = tr[u].l + tr[u].r >> 1;
            if (l <= mid) {
                res = Math.max(res, query(u << 1, l, r));
            }
            if (mid + 1 <= r) {
                res = Math.max(res, query(u << 1 | 1, l, r));
            }
        
            return res;
        }
        
        public int query() {
            return tr[1].v;
        }
    }
}
