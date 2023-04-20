package LeetCodeSubmissions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllThreeElementsWithSumZero {
    public static void main(String[] args) {
        display(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public static void display (List<List<Integer>> nums) {
        System.out.print("[");
        for (List<Integer> list : nums) {
            System.out.print(" [");
            for (Integer num : list) {
                System.out.print(" " + num + " ");
            }
            System.out.print("] ");
        }
        System.out.print("]");
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outputList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int low = i+1, high = nums.length-1;
            while (low < high) {
                if (nums[i] + nums[low] + nums[high] < 0) {
                    low++;
                } else if (nums[i] + nums[low] + nums[high] > 0) {
                    high--;
                } else {
                    outputList.add (new ArrayList<Integer>( Arrays.asList(nums[i], nums[low], nums[high]) ));
                    int temp1 = low, temp2 = high;
                    while (low < high && nums[low] == nums[temp1]) { low++; }
                    while (low < high && nums[high] == nums[temp2]) { high--; }
                }
            }
            while (i+1 < nums.length && nums[i] == nums[i+1]) { i++; }
        }
        return outputList;
    }
}
