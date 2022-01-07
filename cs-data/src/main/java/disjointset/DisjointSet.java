package disjointset;

public class DisjointSet {
    private int[] fa;

    public DisjointSet(int n) {
        fa = new int[n];

        for (int i=0; i < n; i++) {
            fa[i] = i;
        }
    }

    public int find(int x) {
        if (x == fa[x]) {
            return x;
        }
        return fa[x] = find(x);
    }

    public void unionSet(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            fa[x] = y;
        }
    }
}
