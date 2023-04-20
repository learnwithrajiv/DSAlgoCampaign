package LeetCodeSubmissions.Matrix;

public class MatrixNumberOfIslands {
    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                new char[] {'1','1','1','1','0'},
                new char[] {'1','1','0','1','0'},
                new char[] {'1','1','0','0','0'},
                new char[] {'0','0','0','0','1'}
        };

        System.out.println(countNumberOfIslands(matrix));
    }

    private static int countNumberOfIslands(char[][] matrix) {
        int numOfIslands = 0;
        if (null == matrix || matrix.length == 0) return 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1')
                    numOfIslands += dfs(matrix, i, j);
            }
        }
        return numOfIslands;
    }

    private static int dfs (char[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length || matrix[i][j] == '0') {
            return 0;
        }

        matrix[i][j] = '0';

        dfs(matrix, i-1, j);
        dfs(matrix, i+1, j);
        dfs(matrix, i, j-1);
        dfs(matrix, i, j+1);

        return 1;
    }
}
