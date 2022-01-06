package trie;

public class TrieTest {
    public static void main(String[] args) {
        //trieArray();
        trieMap();
    }

    public static void trieArray() {
        ArrayTrie trie = new ArrayTrie();
        String s1 = "apple";
        trie.insert(s1);
        System.out.println(s1 + " search " + trie.search(s1));

        String s2 = "app";
        System.out.println(s2 + " search " + trie.search(s2));

        System.out.println(s2 + " startWith " + trie.startWith(s2));

        trie.insert(s2);
        System.out.println(s2 + " search " + trie.search(s2));
    }

    public static void trieMap() {
        MapTrie trie = new MapTrie();
        String s1 = "apple";
        trie.insert(s1);
        System.out.println(s1 + " search " + trie.search(s1));

        String s2 = "app";
        System.out.println(s2 + " search " + trie.search(s2));

        System.out.println(s2 + " startWith " + trie.startWith(s2));

        trie.insert(s2);
        System.out.println(s2 + " search " + trie.search(s2));

        String s3 = "abc";
        System.out.println(s3 + " startWith " + trie.startWith(s3));

        String s4 = "a";
        System.out.println(s4 + " startWith " + trie.startWith(s4));

    }
}
