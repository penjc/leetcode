package leedcode.矩阵;

/**
 * 题目描述：
 *      给定一个 m x n 的矩阵，如果某个元素为 0，则将其所在的整行和整列的所有元素设为 0。要求使用原地算法，即不能使用额外的矩阵存储数据。
 * 解题思路：
 * 使用矩阵的第一行和第一列作为标记
 *      由于题目要求原地算法，我们可以利用矩阵的第一行和第一列来存储是否该行或该列需要被置零。
 *      额外使用两个变量：
 *          firstRowHasZero 记录第一行是否有 0。
 *          firstColHasZero 记录第一列是否有 0。
 *      第一遍扫描：
 *          先检查第一行和第一列是否含有 0，如果有，则记录在 firstRowHasZero 和 firstColHasZero。
 *          然后，遍历整个矩阵（跳过第一行和第一列），如果某个元素为 0，就将其对应的第一行和第一列的元素设为 0，表示该行和该列需要置零。
 *      第二遍扫描：
 *          根据第一行和第一列的标记信息，将相应的行和列置零。
 *      最后单独处理第一行和第一列：
 *          如果 firstRowHasZero 为 true，就将第一行全部置零。
 *          如果 firstColHasZero 为 true，就将第一列全部置零。
 */
public class Lc73 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length, n = matrix[0].length;
        boolean firstRowHasZero = false, firstColHasZero = false;

        // Step 1: 记录第一行和第一列是否有 0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // Step 2: 用第一行和第一列来标记需要置零的行和列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 3: 置零操作（根据标记信息）
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 4: 单独处理第一行和第一列
        if (firstRowHasZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstColHasZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public void setZeros(int[][] matrix){
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for(int i = 0; i < m; i++){
            if(row[i]){
                for(int j = 0; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
