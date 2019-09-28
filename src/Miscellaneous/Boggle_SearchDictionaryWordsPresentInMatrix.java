package Miscellaneous;

/*
Given a dictionary, a method to do a lookup in the dictionary and a M x N board where every cell has one character.
Find all possible words that can be formed by a sequence of adjacent characters.
Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of the same cell.

Example:

Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
       boggle[][]   = {{'G','I','Z'},
                       {'U','E','K'},
                       {'Q','S','E'}};
      isWord(str): returns true if str is present in dictionary
                   else false.

Output:  Following words of the dictionary are present
         GEEKS
         QUIZ
*/
public class Boggle_SearchDictionaryWordsPresentInMatrix {
    private static final int ALPHABET_SIZE = 26;
    private static int M = 3, N = 3;

    private static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        public TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    private static TrieNode root;

    private static void insert (TrieNode root, String word) {
        int index;
        TrieNode charCrawl = root;

        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'A';
            if (charCrawl.children[index] == null) {
                charCrawl.children[index] = new TrieNode();
            }
            charCrawl = charCrawl.children[index];
        }
        charCrawl.isEndOfWord = true;
    }

    private static boolean isSafe (int i, int j, boolean visited[][]) {
        return (i >= 0 && i < M && j >= 0 && j < M && !visited[i][j]);
    }

    private static void searchWord (TrieNode root, char boggle[][], int i, int j, boolean[][] visited, String str) {
        if (root.isEndOfWord) {
            System.out.println(str);
        }
        if (isSafe(i, j, visited)) {
            visited[i][j] = true;
            for (int k = 0; k < ALPHABET_SIZE; k++) {
                char ch = (char) (k + 'A');
                if (root.children[k] != null) {
                    if (isSafe(i+1,j, visited) && boggle[i+1][j] == ch) {
                        searchWord(root.children[k], boggle, i+1, j, visited, str+ch);
                    }
                    if (isSafe(i-1,j, visited) && boggle[i-1][j] == ch) {
                        searchWord(root.children[k], boggle, i-1, j, visited, str+ch);
                    }
                    if (isSafe(i,j+1, visited) && boggle[i][j+1] == ch) {
                        searchWord(root.children[k], boggle, i, j+1, visited, str+ch);
                    }
                    if (isSafe(i,j-1, visited) && boggle[i][j-1] == ch) {
                        searchWord(root.children[k], boggle, i, j-1, visited, str+ch);
                    }
                    if (isSafe(i+1,j+1, visited) && boggle[i+1][j+1] == ch) {
                        searchWord(root.children[k], boggle, i+1, j+1, visited, str+ch);
                    }
                    if (isSafe(i+1,j-1, visited) && boggle[i+1][j-1] == ch) {
                        searchWord(root.children[k], boggle, i+1, j-1, visited, str+ch);
                    }
                    if (isSafe(i-1,j+1, visited) && boggle[i-1][j+1] == ch) {
                        searchWord(root.children[k], boggle, i-1, j+1, visited, str+ch);
                    }
                    if (isSafe(i-1,j-1, visited) && boggle[i-1][j-1] == ch) {
                        searchWord(root.children[k], boggle, i-1, j-1, visited, str+ch);
                    }
                }
            }
            visited[i][j] = false;
        }
    }

    private static void findWords (char boggle[][], TrieNode root) {
        boolean[][] visited = new boolean[M][N];
        TrieNode charCrawl = root;

        String str = "";

        for (int i = 0; i < M; i ++) {
            for (int j = 0; j < N; j ++) {
                if (charCrawl.children[boggle[i][j] - 'A'] != null) {
                    str += boggle[i][j];
                    searchWord (charCrawl.children[boggle[i][j] - 'A'], boggle, i, j, visited, str);
                    str = "";
                }
            }
        }
    }

    public static void main(String args[])
    {
        // Let the given dictionary be following
        String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};

        // root Node of trie
        root = new TrieNode();

        // insert all words of dictionary into trie
        int n = dictionary.length;
        for (int i=0; i<n; i++)
            insert(root, dictionary[i]);

        char boggle[][] = {{'G','I','Z'},
                {'U','E','K'},
                {'Q','S','E'}
        };
        System.out.println();
        findWords(boggle, root);

    }
}