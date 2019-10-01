package Arrays;

public class SearchElementInSortedAndRotatedArray {
    public static int search (int[] arr, int l, int h, int key) {
        if (l > h)
            return -1;

        int mid = (l+h)/2;
        if (arr[mid] == key)
            return mid;

        if (arr[l] <= arr[mid]) {
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid-1, key);
            return search(arr, mid+1, h, key);
        }

        if (key >= arr[mid] && key <= arr[h])
            return search (arr, mid+1, h, key);
        return search(arr, l, mid-1, key);
    }

    public static void displayPosition (int position) {
        if (position == -1) {
            System.out.println("Key not found!");
        } else {
            System.out.println("Key position: " + (position+1));
        }
    }
    public static void main (String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 1, 2, 3};
        displayPosition(search(arr, 0, (arr.length-1), 6));
        displayPosition(search(arr, 0, (arr.length-1), 1));
        displayPosition(search(arr, 0, (arr.length-1), 12));
        displayPosition(search(arr, 0, (arr.length-1), 2));
    }
}
