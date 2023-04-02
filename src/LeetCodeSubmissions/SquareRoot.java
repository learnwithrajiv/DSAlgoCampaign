package LeetCodeSubmissions;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        if(x == 0) return 0;
        int low = 1, high = x, ans =0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(x/mid == mid)  return mid;
            if(x/mid < mid) high = mid-1;
            else { low = mid + 1; ans = mid; }
        }
        return ans;
    }
}
