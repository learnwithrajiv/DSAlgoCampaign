package LeetCodeSubmissions.Matrix;

public class CreateMatrixInSpiralOrder {
    public static void main(String[] args) {
        display ( generateMatrix(5), 5 );
    }

    public static void display (int[][] matrix, int n) {
        for (int i = 0; i < n; i++)  {
            for (int j = 0; j < n; j++)  {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int [][] matrix = new int[n][n];
        int top = 0, left = 0, down = n-1, right = n-1;
        int dir = 0, currentNum = 1;

        while (top <= down && left <= right) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    matrix[top][i] = currentNum++;
                }
                top++;
            } else if (dir == 1) {
                for (int i = top; i <= down; i++) {
                    matrix[i][right] = currentNum++;
                }
                right--;
            } else if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    matrix[down][i] = currentNum++;
                }
                down--;
            } else if (dir == 3) {
                for (int i = down; i >= top; i--) {
                    matrix[i][left] = currentNum++;
                }
                left++;
            }
            dir = (dir + 1) % 4;
        }
        return matrix;
    }
}
