package leedcode100.矩阵;

/**
 * 题目描述：
 *      我们需要在一个 m x n 的矩阵 matrix 中查找 target，并且该矩阵满足以下特性：
 *      每行从左到右递增。
 *      每列从上到下递增。
 * 解题思路：
 *      从右上角开始查找
 *      每次决策可以减少搜索范围：
 *          向左移动：排除当前列（所有值都更大）。
 *          向下移动：排除当前行（所有值都更小）。
 */
public class Lc240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1; // 从右上角开始

        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--; // 向左移动
            } else {
                row++; // 向下移动
            }
        }
        return false;
    }
}
