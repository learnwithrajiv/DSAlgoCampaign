package DictionaryImplUsingTrie;

/*
    INSERT, SEARCH
*/
public class DictionaryTrie {
    public static int ALPHABET_SIZE = 26;

    private static class TrieNode {
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

    public static void insert (String word) {
        int index;
        TrieNode charCrawl = root;

        for (int level = 0; level < word.length(); level++) {
            index = word.charAt(level) - 'a';
            if (charCrawl.children[index] == null) {
                charCrawl.children[index] = new TrieNode();
            }
            charCrawl = charCrawl.children[index];
        }
        charCrawl.isEndOfWord = true;
    }

    public static boolean search (String word) {
        int index;
        TrieNode charCrawl = root;

        for (int level = 0; level < word.length(); level++) {
            index = word.charAt(level) - 'a';
            if (charCrawl.children[index] == null) {
                return false;
            }
            charCrawl = charCrawl.children[index];
        }
        return (charCrawl != null && charCrawl.isEndOfWord);
    }

    public static void main(String args[])
    {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};


        root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            insert(keys[i]);

        // Search for different keys
        if(search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if(search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if(search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);

    }
}
