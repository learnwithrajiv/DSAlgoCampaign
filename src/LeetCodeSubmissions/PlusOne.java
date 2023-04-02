package LeetCodeSubmissions;

public class PlusOne {
    public static void main(String[] args) {
        display(plusOne(new int[]{1,2,3}));
        display(plusOne(new int[]{9, 9}));
    }

    private static void display (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static int[] plusOne (int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
