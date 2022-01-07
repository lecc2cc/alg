package trie;

import java.util.*;
import java.util.stream.Collectors;

public class WordSearch2 {
    /**
     * 1. 按四个方向，递归遍历
     * 2. 如果字符存在Trie树中，判断是否单词
     * 3. 维护一个字符栈，记录每次在Trie树中的字符串，如果是一个单词，则保存答案
     * 4. 搜索一个Trie节点的时，如果没有子节点，则该点不再被用于搜索，可以删除
     *
     *
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        // 1 新建Trie树
        for (String s : words) {
            insert(s);
        }
        this.rows = board.length;
        this.cols = board[0].length;
        visited = new boolean[this.rows][this.cols];
        // 搜索，任意点开始递归，每次从根节点开始
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                visited[i][j] = true;

                dfs(board, i, j, root);

                visited[i][j] = false;

            }
        }

        return new ArrayList<String>(ans);
    }

    /**
     * 四个方向递归
     *
     * @param board
     * @param x
     * @param y
     * @param cur
     */
    private void dfs(char[][] board, int x, int y, Node cur) {
        char ch = board[x][y];
        if (cur == null) {
            return;
        }
        if (!cur.child.containsKey(ch)) {
            return;
        }

        Node next = cur.child.get(ch);

        viewBuf.append(ch);
        // 是一个单词，记录答案
        if (next.count > 0) {
            ans.add(viewBuf.toString());
        }

        // 一个点没有子节点，不再用于搜索，则可以删掉
        // 答案只需要出现就可以，而不是所有方案
        if (next.child.size() == 0) {
            cur.child.remove(ch);
        } else {
            // 递归四个方向
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= this.rows || ny >= this.cols) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                dfs(board, nx, ny, next);
                visited[nx][ny] = false;
            }
        }

        // 还原现场
        if (viewBuf.length() > 0) {
            viewBuf.deleteCharAt(viewBuf.length() - 1);
        }

    }


    private Set<String> ans = new HashSet<>();
    private StringBuffer viewBuf = new StringBuffer();
    private int rows;
    private int cols;
    private boolean[][] visited;
    private int[] dx = new int[]{-1, 0, 0, 1};
    private int[] dy = new int[]{0, -1, 1, 0};
    private Node root = new Node();

    /**
     * 插入维护Trie树
     *
     * @param word
     */
    private void insert(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()) {
            // 不存在
            if (!cur.child.containsKey(ch)) {
                cur.child.put(ch, new Node());
            }

            cur = cur.child.get(ch);
        }

        cur.count++;
    }

    /**
     * 节点
     */
    class Node {
        /**
         * 单词统计，0表示中间前缀，并不是一个完整的词
         */
        int count;

        Map<Character, Node> child;

        Node() {
            this.count = 0;
            this.child = new HashMap<>();
        }
    }
}
