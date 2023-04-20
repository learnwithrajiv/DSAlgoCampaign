package LeetCodeSubmissions.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraversal {
    public static void main(String[] args) {
        int[][] matrix = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        for (Integer val : spiralOrder(matrix)) {
            System.out.print(val + " ");
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, left = 0, down = matrix.length-1, right = matrix[0].length-1;
        int direction = 0;
        List<Integer> spiralList = new ArrayList<>();

        while (top <= down && left <= right) {
            if (direction == 0) {                           // left to right
                for (int i = left; i <= right; i++) {
                    spiralList.add (matrix[top][i]);
                }
                top++;
            } else if (direction == 1) {                    // top to down
                for (int i = top; i <= down; i++) {
                    spiralList.add (matrix[i][right]);
                }
                right--;
            } else if (direction == 2) {                    // right to left
                for (int i = right; i >= left; i--) {
                    spiralList.add (matrix[down][i]);
                }
                down--;
            } else if (direction == 3) {                    // down to top
                for (int i = down; i >= top; i--) {
                    spiralList.add (matrix[i][left]);
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }
        return spiralList;
    }
}
