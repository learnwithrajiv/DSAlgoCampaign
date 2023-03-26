package Arrays;

/*
Time complexity: O(m+n)O(m+n)O(m+n)

Idea:
We create a new array with length that of the sum of the array lengths
We initialize i & j = 0. [i for nums1 & j for nums2]
Since the given arrays are already sorted it is easy to compare their elements. We comapre by observing nums1[i] < nums2[j]
if the element in nums1nums1nums1 at ithi^{th}i
th
  is less than that of element at jthj^{th}j
th
  index of nums2nums2nums2, we add nums1[i]nums1[i]nums1[i] to new array and increment i; so as to compare the next element of the array to nums2[j].
If the opposite case arises, we add nums2[j]nums2[j]nums2[j] to the new array as you can guess. And increment j by 1 for the same reasons we did it with i.
Depending on the length of new array, we calculate median.
If the length of array is even, median by rule is the average of the 2 middle elements of the array
If it is off, it is the middlemost element
 */

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int[] retVal = new int[n];

        int i = 0, j = 0, k = 0;

        while (i <= n1 && j <= n2)  {
            if (i == n1) {
                while (j < n2) {  retVal[k++] = nums2[j++];  }
                break;
            } else if (j == n2) {
                while (i < n1) {  retVal[k++] = nums1[i++];  }
                break;
            }

            if (nums1[i] < nums2[j]) {
                retVal[k++] = nums1[i++];
            } else {
                retVal[k++] = nums2[j++];
            }

        }

        if (n % 2 == 0) {
            return (float)(retVal[n/2 - 1] + retVal[n/2])/2;
        }
        return (float)(retVal[n/2]);
    }
}
