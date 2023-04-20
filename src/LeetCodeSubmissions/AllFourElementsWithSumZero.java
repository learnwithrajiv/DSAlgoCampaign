package LeetCodeSubmissions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllFourElementsWithSumZero {
    public static void main(String[] args) {
        display(fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        display(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
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
        System.out.println("]");
    }

    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        if (nums[0] > 0 && target < 0) return output;
        for(int i=0; i<n-3; i++){
            for(int j=i+1; j<n-2; j++){
                long newTarget = (long)target - (long)nums[i] - (long)nums[j];
                int low = j+1, high = n-1;
                while(low < high){
                    if(nums[low] + nums[high] < newTarget){
                        low++;
                    }
                    else if(nums[low] + nums[high] > newTarget){
                        high--;
                    }
                    else{
                        output.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        int tempIndex1 = low, tempIndex2 = high;
                        while(low < high && nums[low] == nums[tempIndex1]) low++;
                        while(low < high && nums[high] == nums[tempIndex2]) high--;
                    }
                }
                while(j+1 < n && nums[j] == nums[j+1]) j++;
            }
            while(i+1 < n && nums[i] == nums[i+1]) i++;
        }
        return output;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n-3; i++) {
            for (int j = i+1; j < n-2; j++) {
                long remainingTarget = (long)target - (long)nums[i] - (long)nums[j];
                int low = j+1, high = n-1;
                while (low < high) {
                    if ((long)(nums[low] + nums[high]) < remainingTarget) {
                        low++;
                    } else if ((long)(nums[low] + nums[high]) > remainingTarget) {
                        high--;
                    } else {
                        output.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[low], nums[high])));
                        int temp1 = low, temp2 = high;
                        while (low < high && nums[low] == nums[temp1]) low++;
                        while (low < high && nums[high] == nums[temp2]) high--;
                    }
                }
                while(j+1 < n && nums[j] == nums[j+1]) j++;
            }
            while(i+1 < n && nums[i] == nums[i+1]) i++;
        }
        return output;
    }
}
