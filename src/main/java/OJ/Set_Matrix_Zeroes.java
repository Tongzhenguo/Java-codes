package OJ;

/**
 * Created by arachis on 2017/4/24.
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * 一个m x n的矩阵，设计原地算法，设置0元素的行列
 */

public class Set_Matrix_Zeroes {

    public void setZeroes(int[][] matrix) {
        boolean fr = false;// fr = first row
        boolean fc = false; // fc = first col
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {// mark respected row and col marker = 0;
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                    // indicating that later this respective row and col must be marked 0;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                // So, for ex, if any one of the first row is 0, fr = 0,
                // /and at the end set all first row to 0;
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (fr) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (fc) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
