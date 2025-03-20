package leedcode.矩阵;

import java.util.*;

/**
 * 题目描述：
 *      给定一个 m x n 的矩阵 matrix，按照顺时针螺旋顺序返回所有元素。
 * 使用四个变量来标记当前矩阵的边界：
 *      top（上边界）
 *      bottom（下边界）
 *      left（左边界）
 *      right（右边界）
 * 具体步骤：
 *      从左到右遍历 top 行，然后 top++
 *      从上到下遍历 right 列，然后 right--
 *      如果 top <= bottom，从右到左遍历 bottom 行，然后 bottom--
 *      如果 left <= right，从下到上遍历 left 列，然后 left++
 *      重复上述步骤，直到遍历完整个矩阵。
 */
public class Lc54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            // 从左到右遍历顶行
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;

            // 从上到下遍历最右列
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // 从右到左遍历底行（确保仍然有行）
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // 从下到上遍历最左列（确保仍然有列）
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
