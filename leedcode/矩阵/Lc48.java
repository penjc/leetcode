package leedcode.矩阵;

/**
 * 题目描述：
 *      输入：一个 `n x n 的二维矩matrix，表示一
 *      要求：必须在原地修改矩阵，不能使用另一个矩阵
 * 解题思路：
 *      1. 先转置矩阵（行变列）
 *      2. 再水平翻转矩阵
 */
public class Lc48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: 先转置矩阵（行变列）
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // 避免重复交换
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: 水平翻转矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

}

