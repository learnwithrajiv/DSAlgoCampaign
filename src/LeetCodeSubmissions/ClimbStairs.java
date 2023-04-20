package LeetCodeSubmissions;

import java.util.Arrays;


/*
Using Top - Down Approach -> Recursion + Memorization.
Storing the values of overlapping sub - problems in an array.

Time complexity:
O(n) -> As we are visiting all values of n atleast 1 time.

Space complexity:
O(n) + O(n) - > (Recursive calls + Array of size n)
*/

//      USING LOOP
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }

    //      USES O(n) space to store results in an array
//    private static int climbStairs (int n) {
//        if (n == 1 || n == 2) return n;
//
//        int[] arr = new int[n];
//
//        arr[0] = 1;
//        arr[1] = 2;
//
//        for (int i = 2; i < n; i++) {
//            arr[i] = arr[i-1] + arr[i-2];
//        }
//        return arr[n-1];
//    }

    //      DOESN'T USE ANY EXTRA SPACE
    private static int climbStairs (int n) {
        if (n == 1 || n == 2) return n;

        int x = 1;
        int y = 2;

        for (int i = 2; i < n; i++) {
            int temp = x; x = y; y = temp + y;
        }
        return y;
    }
}

//      USING DYNAMIC PROGRAMMING
//public class ClimbStairs {
//    public static void main(String[] args) {
//        System.out.println(climbStairs(10));
//    }
//
//    public static int solve(int n, int[] dp){
//        // base case
//        if(n<=2)
//            return n;
//
//        if(dp[n]!=-1)
//            return dp[n];
//
//        dp[n]=solve(n-1, dp) + solve(n-2, dp);
//        return dp[n];
//    }
//
//    public static int climbStairs(int n) {
//        if(n<=2)
//            return n;
//        int[] dp = new int[n+1];
//        Arrays.fill(dp, -1);
//        return solve(n, dp);
//    }
//}
