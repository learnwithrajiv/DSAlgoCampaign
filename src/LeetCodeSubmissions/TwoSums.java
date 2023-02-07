package LeetCodeSubmissions;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

Constraints:
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

 */
public class TwoSums {
    public static void main (String[] args) {
        int[] nums = new int[] {2,7,11,15};
        int target = 9;

        displayResult(twoSum(nums, target));

        nums = new int[] {3,2,4};
        target = 6;
        displayResult(twoSum(nums, target));

        nums = new int[] {3,3};
        target = 6;
        displayResult(twoSum(nums, target));
    }

    private static int[] twoSum(int[] nums, int target) {
        int remaining = 0;
        int[] retVal = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            remaining = target - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (remaining - nums[j] == 0) {
                    retVal[0] = i;
                    retVal[1] = j;
                }
            }
        }
        return retVal;
    }

    //BETTER PERFORMANCE
    private static int[] twoSum_better(int[] nums, int target) {
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] + nums[j + i] == target) {
                    return new int[]{j, j + i};
                }
            }
        }
        return null;
    }

    public static void displayResult(int[] result) {
        System.out.println();
        for (int  i = 0; i < result.length; i++) {
            System.out.print(result[i] + "  ");
        }
    }
}
