package LeetCodeSubmissions;

import java.util.ArrayList;
import java.util.List;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);

Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Example 3:
Input: s = "A", numRows = 1
Output: "A"

Constraints:
1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
*/

public class StringZigZagConversion {
    public static void main (String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("PAYPALISHIRING", 1));
    }

    private static String convert(String s, int numRows) {
        if (s.isEmpty() || s.length() < numRows || numRows <= 1) {
            return s;
        }
        List<StringBuilder> retVal = new ArrayList<>();
        int i = 0;
        boolean forward = true;
        for (char c : s.toCharArray()) {
            if (retVal.size() <= i) {
                retVal.add(new StringBuilder());
            }
            retVal.get(i).append(c);
            if (forward) {
                i++;
            } else {
                i--;
            }
            if (i == numRows-1) {
                forward = false;
            } else if (i == 0){
                forward = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder sb1 : retVal) {
            sb.append(sb1.toString());
        }
        return sb.toString();
    }
}
