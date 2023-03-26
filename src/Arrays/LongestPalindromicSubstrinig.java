package Arrays;

/*
For odd length palindromes, the basic idea is to fix the center of the palindrome and expand outwards
until the palindrome is no longer valid. Here is an algorithmic approach:
- Initialize two pointers, left and right, to the center of the string.
- While the characters at indices left and right are equal, increment left and decrement right.
- The length of the longest palindrome centered at the current index is 2 * (center - left) - 1.
- Keep track of the maximum length palindrome and its center.

For even length palindromes, the basic idea is to fix the two centers of the palindrome and expand outwards
until the palindrome is no longer valid. Here is an algorithmic approach:
- Initialize two pointers, left and right, to the center of the string.
- While the characters at indices left and right are equal, increment left and decrement right.
- The length of the longest palindrome centered at the current index is 2 * (center - left) - 1.
- Keep track of the maximum length palindrome and its center.
- Initialize two pointers, left and right, to the center of the string and its right neighbor.
- While the characters at indices left and right are equal, increment left and decrement right.
- The length of the longest palindrome centered at the current index is 2 * (center - left) - 1.
- Keep track of the maximum length palindrome and its center.

By combining these two approaches, we can find the longest palindromic substring in a given string.
The time complexity of this algorithm is O(n^2) since we need to check each possible center of the palindrome.
However, there are more efficient algorithms such as Manacher's algorithm that can solve this problem in O(n) time complexity.
 */
public class LongestPalindromicSubstrinig {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String str) {
        int s = 0, e = 0;
        for (int i = 0; i  < str.length(); i++) {
            int odd = palindrome (str, i, i);
            int even = palindrome (str, i, i+1);

            int length = Math.max(odd, even);

            if (length > (e-s)) {
                s = i - (length-1)/2;
                e = i + length/2;
            }
        }
        return str.substring(s, e+1);
    }

    public static int palindrome (String str, int s, int e) {
        while (s >= 0 && e < str.length() && str.charAt(s) == str.charAt(e)) {
            s--;
            e++;
        }
        return e-s-1;
    }
}
