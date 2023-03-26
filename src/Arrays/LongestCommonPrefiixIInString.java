package Arrays;

import java.util.Arrays;

/*
Approach
This code is used to find the longest common prefix of an array of strings, which is defined as the longest string that is a prefix of all the strings in the array. By sorting the array and then comparing the first and last elements, the code is able to find the common prefix that would be shared by all strings in the array.

Sort the elements of an array of strings called "strs" in lexicographic (alphabetical) order using the Arrays.sort(strs) method.
Assign the first element of the sorted array (the lexicographically smallest string) to a string variable s1.
Assign the last element of the sorted array (the lexicographically largest string) to a string variable s2.
Initialize an integer variable idx to 0.
Start a while loop that continues while idx is less than the length of s1 and s2.
Within the while loop, check if the character at the current index in s1 is equal to the character at the same index in s2. If the characters are equal, increment the value of idx by 1.
If the characters are not equal, exit the while loop.
Return the substring of s1 that starts from the first character and ends at the idxth character (exclusive).

Complexity
Time complexity:
Sorting the array of strings takes O(Nlog(N)) time. This is because most of the common sorting algorithms like quicksort, mergesort, and heapsort have an average time complexity of O(Nlog(N)).
Iterating over the characters of the first and last strings takes O(M) time. This is because the code compares the characters of the two strings until it finds the first mismatch.
Therefore, the total time complexity is O(Nlog(N) + M).

Space complexity:
The space used by the two string variables s1 and s2 is proportional to the length of the longest string in the array. Therefore, the space complexity is O(1) as it does not depend on the size of the input array.
*/

public class LongestCommonPrefiixIInString {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }
}
