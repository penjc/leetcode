package leedcode100.二分查找;

/**
 * 74. 搜索二维矩阵
 * 题目描述：
 *      给你一个满足下述两条属性的 m x n 整数矩阵：
 *      每行中的整数从左到右按非严格递增顺序排列。
 *      每行的第一个整数大于前一行的最后一个整数。
 *      给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 * 解题思路：
 *      由于矩阵的特殊性，我们可以将矩阵展开成一个有序数组，然后使用二分查找来解决。
 */
public class Lc74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n]; // 计算 mid 对应的矩阵元素

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
