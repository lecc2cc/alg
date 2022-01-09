class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        int[] fa = new int[edges.length + 1];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }

        for (int i = 0; i <edges.length;i++) {
            if (!unionSet(fa, edges[i][0], edges[i][1])) {
                return edges[i];
            }
        }
        return null;
    }

    int find(int[] fa, int x) {
        if (x == fa[x]) {
            return x;
        }
        return fa[x] = find(fa, fa[x]);
    }

    boolean unionSet(int[] fa, int x, int y) {
        x = find(fa, x);
        y = find(fa, y);
        if (x != y) {
            fa[x] = y;
            return true;
        } else {
            return false;
        }
    }
}
