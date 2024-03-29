package Arrays;

/*
Approach:
This is a solution in Java that reverses an integer and checks if the result is
within the range of a 32-bit signed integer.
The approach involves using a while loop to extract the last digit of the input integer x
and add it to a variable finalNum. At each iteration, finalNum is multiplied by 10 so that
the next extracted digit can be added as the next significant digit. After the loop,
finalNum is divided by 10 to remove the extra trailing zero.

Next, the solution checks if finalNum is greater than the maximum value of a
32-bit signed integer (Integer.MAX_VALUE) or less than its minimum value (Integer.MIN_VALUE).
If either of these conditions is met, the function returns 0 as the result will not fit
within the range of a 32-bit signed integer.

Finally, if x is negative, the solution returns -1 * finalNum as a negative result.
If x is positive, the solution returns finalNum as the final answer.

Time and Space Complexity:
Time complexity:
The time complexity of this solution is O(log(x)) where x is the input integer.
This is because each iteration of the while loop processes the last digit of x and
reduces the size of x by a factor of 10. The number of iterations is logarithmic
with respect to the size of x, thus making the time complexity O(log(x)).

Space complexity:
The space complexity of this solution is O(1) because only a few variables are used
(x, lastDig, and finalNum) and their sizes are constant and do not grow with the size of the input.
 */

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }

    public static int reverse (int x) {
        long finalNum = 0l;
        while (x != 0) {
            int digit = x % 10;
            finalNum = (finalNum * 10) + digit;
            x = x / 10;
        }
        if (finalNum > Integer.MAX_VALUE || finalNum < Integer.MIN_VALUE)
            return 0;
        return (int)finalNum;
    }
}
