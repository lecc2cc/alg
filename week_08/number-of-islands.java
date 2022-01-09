class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int ans = 0;
        int[] fa = new int[rows * cols];
        // 每个'1'都是一个小岛
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    int point = pointNum(cols, i, j);
                    fa[point] = point;
                    ans++;
                }
            }
        }


        int[] dx = new int[]{-1, 0, 0, 1};
        int[] dy = new int[]{0, -1, 1, 0};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }


                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || ny < 0 || nx >= rows || ny >= cols) {
                        continue;
                    }
                    // 合并成大岛
                    if (grid[nx][ny] == '1') {
                        if (unionSet(fa, pointNum(cols, i, j), pointNum(cols, nx, ny))) {
                            ans--;
                        }
                    }

                }
            }
        }


        //System.out.println(Arrays.toString(fa) + " \n " + ans);
        return ans;
    }

    int pointNum(int cols, int x, int y) {
        return x * cols + y;
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
