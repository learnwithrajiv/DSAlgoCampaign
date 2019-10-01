package Arrays;

import java.util.Scanner;

/*
Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.
=========================================================================================================================
Input:
The first line of input contains an integer T denoting the number of test cases.
Then T test cases follow. Each test case consists of two lines.
The first line of each test case is N and S, where N is the size of array and S is the sum.
The second line of each test case contains N space separated integers denoting the array elements.

Output:
For each testcase, in a new line, print the starting and ending positions(1 indexing)
of first such occuring subarray from the left if sum equals to subarray, else print -1.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= Ai <= 1010

Example:
Input:
2
5 12
1 2 3 7 5
10 15
1 2 3 4 5 6 7 8 9 10
Output:
2 4
1 5

Explanation :
Testcase1: sum of elements from 2nd position to 4th position is 12
Testcase2: sum of elements from 1st position to 5th position is 15
*/
public class LongestSubArrayWithGivenSum {
    public static void findSubArray (int[] arr, int n, int s) {
        int first = 0, last = 0;
        long result = arr[first];

        while (result != s) {
            if (result > s) {
                if (first == last) {
                    first++;
                    last++;
                    if (last > n)
                        break;
                    result = arr[first];
                } else {
                    result -= arr[first];
                    first++;
                }
            } else {
                last++;
                if (last < n)
                    result += arr[last];
                else
                    break;
            }
        }
        if (result != s) {
            System.out.println(-1);
        } else {
            System.out.println((first + 1) + " " + (last + 1));
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            findSubArray(arr, n, s);
        }
    }
}
