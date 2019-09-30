package DictionaryImplUsingTrie;

public class DictionaryTrie_BottomUpTraversal {
    private static final int ALPHABET_SIZE = 26;

    public static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        TrieNode () {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    static TrieNode root;

    private static void insert (String word) {
        int index;
        TrieNode childCrawl = root;

        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            if (childCrawl.children[index] == null) {
                childCrawl.children[index] = new TrieNode();
            }
            childCrawl = childCrawl.children[index];
        }
        childCrawl.isEndOfWord = true;
    }

    private static void trieBottomUpTraversal (TrieNode root) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (root.children[i] != null) {
                trieBottomUpTraversal(root.children[i]);
                System.out.print((char) (i + 'a') + ", ");
            }
        }
    }

    public static void main (String[] args) {
        // Input keys (use only 'a' through 'z' and lower case)
//        String keys[] = {"the", "a", "there", "answer", "any",
//                "by", "bye", "their"};
        String keys[] = {"thier", "there", "answer", "any"};

        root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            insert(keys[i]);

        trieBottomUpTraversal(root);
    }
}
