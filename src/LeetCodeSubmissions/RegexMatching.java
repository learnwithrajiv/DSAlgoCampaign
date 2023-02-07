package LeetCodeSubmissions;

/*
Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:
Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

Constraints:
1 <= s.length <= 20
1 <= p.length <= 30
s contains only lowercase English letters.
p contains only lowercase English letters, '.', and '*'.
It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
*/

// INCOMPLETE SOLUTION

public class RegexMatching {
    public static void main (String[] args) {
        System.out.println("Test case 1: " + isMatch("aaa", "a*a"));
        System.out.println("Test case 1: " + isMatch("aaa", "aaaa"));
        System.out.println("Test case 1: " + isMatch("aa", "a"));
        System.out.println("Test case 2: " + isMatch("aa", "a*"));
        System.out.println("Test case 3: " + isMatch("ab", ".*"));
        System.out.println("Test case 4: " + isMatch("aab", "c*a*b"));
        System.out.println("Test case 5: " + isMatch("mississippi", "mis*is*p*."));
        System.out.println("Test case 6: " + isMatch("mississippi", "mis*is*ip*."));
    }

    private static boolean isMatch(String s, String p) {
//        if (s.equals(p) || p.equals(".*")) {
//            return true;
//        }
//        char anyCharExpression = '.', occurenceExpression = '*', lastChar = '0';
//        int i, j;
//        for (i = 0, j = 0; i < s.length() && j < p.length(); i++, j++) {
//            if (p.charAt(j) == anyCharExpression) {
//                continue;
//            } else if (p.charAt(j) == occurenceExpression || (j < p.length()-1 && p.charAt(j+1) == occurenceExpression)) {
//                lastChar = p.charAt(j);
//                while (i < s.length() && s.charAt(i) == lastChar)
//                    i++;
//                i--;
//                j++;
//            } else if (s.charAt(i) != p.charAt(j)) {
//                break;
//            }
//        }
//        return (i >= s.length() && (j >= p.length() || p.charAt(j) == lastChar));
        return false;
    }
}
