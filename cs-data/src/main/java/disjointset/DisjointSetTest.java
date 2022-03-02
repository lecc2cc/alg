package disjointset;

import utils.Fmt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DisjointSetTest {

    public static void main(String[] args) {
        int[][] nums = new int[5][2];
        nums[0] = new int[]{1, 2};
        nums[1] = new int[]{2, 3};
        nums[2] = new int[]{3, 4};
        nums[3] = new int[]{1, 4};
        nums[4] = new int[]{1, 5};

        nums = new int[3][2];
        nums[0] = new int[]{1, 2};
        nums[1] = new int[]{1, 3};
        nums[2] = new int[]{2, 3};

        nums = new int[4][2];
        nums[0] = new int[]{1, 2};
        nums[1] = new int[]{2, 3};
        nums[2] = new int[]{3, 4};
        nums[3] = new int[]{1, 4};
        //nums[3] = new int[]{3, 4};

        int[] ans = findRedundantConnection(nums);
        Fmt.println(ans);


        Fmt.println("----------");
        char[][] grid = new char[4][5];
        grid[0] = new char[]{'1', '1', '0', '0', '0'};
        grid[1] = new char[]{'1', '1', '0', '0', '0'};
        grid[2] = new char[]{'0', '0', '1', '0', '0'};
        grid[3] = new char[]{'0', '0', '0', '1', '1'};

//        grid[0] = new char[]{'1', '1', '1', '1', '0'};
//        grid[1] = new char[]{'1', '1', '0', '1', '0'};
//        grid[2] = new char[]{'1', '1', '0', '0', '0'};
//        grid[3] = new char[]{'0', '0', '0', '0', '0'};
        numIslands(grid);

    }

    public static int numIslands(char[][] grid) {
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


        System.out.println(Arrays.toString(fa) + " \n " + ans);
        return ans;
    }

    static int pointNum(int cols, int x, int y) {
        return x * cols + y;
    }


    public static int[] findRedundantConnection(int[][] edges) {
        int[] fa = new int[edges.length + 1];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            if (!unionSet(fa, edges[i][0], edges[i][1])) {
                return edges[i];
            }
        }
        return null;
    }

    static int find(int[] fa, int x) {
        if (x == fa[x]) {
            return x;
        }
        return fa[x] = find(fa, fa[x]);
    }

    static boolean unionSet(int[] fa, int x, int y) {
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
