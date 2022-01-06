package trie;

/**
 * 字符集数组法
 */
public class ArrayTrie {
    /**
     * 根节点
     */
    Node root;

    public ArrayTrie() {
        this.root = new Node();
    }

    /**
     * 插入一个节点
     * @param word
     */
    public void insert(String word) {
        find(word, true, false);
    }

    /**
     * 查找单词是否存在
     *
     * @param word
     * @return
     */
    public boolean search(String word) {
        return find(word, false, false);
    }

    /**
     * 是否一个前缀，而不是单词
     * @param prefix
     * @return
     */
    public boolean startWith(String prefix) {
        return find(prefix, false, true);
    }



    /**
     * 查找
     *
     * @param s 目标字符串
     * @param isInsert 是否插入新节点
     * @param isPrefix 是否查找前缀，默认查找一个词
     * @return boolean
     */
    private boolean find(String s, boolean isInsert, boolean isPrefix) {
        Node cur = root;
        // 遍历原字符串的字符
        for(char ch : s.toCharArray()) {
            int index = ch - 'a';
            // 不存在
            if (cur.child[index] == null) {
                if (isInsert) {
                    cur.child[index] = new Node();
                } else {
                    return false;
                }
            }

            cur = cur.child[index];
        }

        if (isInsert) {
            cur.count++;
        }
        // 是否前缀
        if (isPrefix) {
            return true;
        }
        // 是否单词
        return cur.count > 0;
    }

    /**
     * 节点
     *
     * 每个都有26个子节点表示对应的单词的字符
     */
    class Node {
        /**
         * 单词统计，0表示中间前缀，并不是一个完整的词
         */
        int count;

        /**
         * 26个字母，表示一个词的字符
         *
         * 0表示a, 1表示b, ...
         */
        Node[] child;

        Node() {
            this.count = 0;
            this.child = new Node[26];
        }
    }
}
