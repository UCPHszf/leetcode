package hashmap;


import java.util.Arrays;

public class ZeroMat {
    public void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length], col = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 1) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int j = 0; j < col.length; j++) {
            if (col[j] == 1) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
