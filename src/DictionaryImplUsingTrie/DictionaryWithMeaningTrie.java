package DictionaryImplUsingTrie;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DictionaryWithMeaningTrie {
    public static int ALPHABET_SIZE = 26;

    private static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;
        String meaning;

        TrieNode () {
            isEndOfWord = false;
            meaning = null;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    static TrieNode root;

    public static void insert (String word, String meaning) {
        int index;
        TrieNode charCrawl = root;
        for (int level = 0; level < word.length(); level++) {
            index = word.charAt(level) - 'a';
            if (charCrawl.children[index] == null) {
                charCrawl.children[index] = new TrieNode();
            }
            charCrawl = charCrawl.children[index];
        }
        charCrawl.meaning = meaning;
        charCrawl.isEndOfWord = true;
    }

    public static String search (String word) {
        int index;
        TrieNode charCrawl = root;

        for (int level = 0; level < word.length(); level++) {
            index = word.charAt(level) - 'a';
            if (charCrawl.children[index] == null) {
                return "No meaning present for this word!";
            }
            charCrawl = charCrawl.children[index];
        }
        return (charCrawl != null && charCrawl.isEndOfWord) ? charCrawl.meaning : "No meaning present for this word!";
    }

    public static void main(String args[])
    {
        // Input keys (use only 'a' through 'z' and lower case)
        Map<String, String> wordMeaning = new HashMap<String, String>() {{
            put("impeccable", "faultless");
            put("note", "a brief of records of facts, topics or thoughts");
            put("entry", "an act of going or coming in");
        }};
        root = new TrieNode();

        // Construct trie
        for (Map.Entry<String, String> entry : wordMeaning.entrySet()) {
            insert(entry.getKey(), entry.getValue());
        }

        // Get meaning of word
        System.out.println("good: " + search("good"));
        System.out.println("entry: " + search("entry"));
        System.out.println("impeccable: " + search("impeccable"));
        System.out.println("note: " + search("note"));

    }
}
