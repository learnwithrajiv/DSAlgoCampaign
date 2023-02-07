package LeetCodeSubmissions;

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Constraints:
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 */

/*
Runtime: 2 ms, Memory: 43 MB
 */
public class MeanAndMedianOfTwoSortedArrays {
    public static void main (String[] args) {
        int[] nums1_1 = new int[] {1,3};
        int[] nums2_1 = new int[] {2};
        System.out.println("\nTest Case1");
        System.out.println("Mean: " + findMeanSortedArrays(nums1_1, nums2_1));
        System.out.println("Median Test Case1: " + findMedianSortedArrays(nums1_1, nums2_1));

        System.out.println("\nTest Case2");
        int[] nums1_2 = new int[] {1};
        int[] nums2_2 = new int[] {2,3,4};
        System.out.println("Mean: " + findMeanSortedArrays(nums1_2, nums2_2));
        System.out.println("Median: " + findMedianSortedArrays(nums1_2, nums2_2));

        System.out.println("\nTest Case3");
        int[] nums1_3 = new int[] {1,3};
        int[] nums2_3 = new int[] {2,7};
        System.out.println("Mean: " + findMeanSortedArrays(nums1_3, nums2_3));
        System.out.println("Median: " + findMedianSortedArrays(nums1_3, nums2_3));

        System.out.println("\nTest Case4");
        int[] nums1_4 = new int[] {1,3};
        int[] nums2_4 = new int[] {};
        System.out.println("Mean: " + findMeanSortedArrays(nums1_3, nums2_3));
        System.out.println("Median: " + findMedianSortedArrays(nums1_4, nums2_4));

        System.out.println("\nTest Case5");
        int[] nums1_5 = new int[] {};
        int[] nums2_5 = new int[] {5};
        System.out.println("Mean: " + findMeanSortedArrays(nums1_3, nums2_3));
        System.out.println("Median: " + findMedianSortedArrays(nums1_5, nums2_5));

        System.out.println("\nTest Case6");
        int[] nums1_6 = new int[] {0,0,0,0,0};
        int[] nums2_6 = new int[] {-1,0,0,0,0,0,1};
        System.out.println("Mean: " + findMeanSortedArrays(nums1_6, nums2_6));
        System.out.println("Median: " + findMedianSortedArrays(nums1_6, nums2_6));

        System.out.println("\nTest Case7");
        int[] nums1_7 = new int[] {1,2};
        int[] nums2_7 = new int[] {-1,3};
        System.out.println("Mean: " + findMeanSortedArrays(nums1_7, nums2_7));
        System.out.println("Median: " + findMedianSortedArrays(nums1_7, nums2_7));
    }

    public static double findMeanSortedArrays(int[] nums1, int[] nums2) {
        int len = (nums1.length < nums2.length) ? nums1.length : nums2.length;
        int i, sum = 0;
        for (i = 0; i < len; i++) {
            sum += nums1[i] + nums2[i];
        }
        if (nums1.length > nums2.length) {
            while (i < nums1.length) {
                sum += nums1[i];
                i++;
            }
        } else {
            while (i < nums2.length) {
                sum += nums2[i];
                i++;
            }
        }
        return (sum / (double)(nums1.length + nums2.length));
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        } else if (nums1.length != 0 && nums2.length == 0) {
            int index = (nums1.length / 2);
            if (nums1.length % 2 == 0) {
                int x = nums1[index-1];
                int y = nums1[index];
                return (x + y)/(double)2;
            }
            return nums1[index];
        } else if (nums1.length == 0 && nums2.length != 0) {
            int index = (nums2.length / 2);
            if (nums2.length % 2 == 0) {
                return (nums2[index-1] + nums2[index])/(double)2;
            }
            return nums2[index];
        } else if ((nums1.length + nums2.length) % 2 == 0) {
            int[] nums =  mergeAndSortArrays(nums1, nums2);
            int index = nums.length/2;
            return (nums[index-1] + nums[index]) / (double)2;
        } else {
            int[] nums =  mergeAndSortArrays(nums1, nums2);
            return (double)(nums[nums.length/2]);
        }
    }

    private static int[] mergeAndSortArrays (int[] nums1, int[] nums2) {
        int[] retVal = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            retVal[k++] = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
        }
        if (j == nums2.length) {
            while (i < nums1.length)
                retVal[k++] = nums1[i++];
        } else if (i == nums1.length) {
            while (j < nums2.length)
                retVal[k++] = nums2[j++];
        }
        return retVal;
    }
}
