package leedcode.多维动态规划;

/**
 * Lc64. 最小路径和
 * 题目描述：
 *      给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 解题思路：
 *      动态规划：
 *      1. 定义状态：dp[i][j] 表示到达位置 (i, j) 的最小路径和；
 *      2. 状态转移方程：
 *      dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])，表示到达 (i, j) 的最小路径和等于当前位置的值加上上方或左方的最小路径和；
 *      3. 初始化：
 *      dp[0][0] = grid[0][0]，表示起点的路径和为自身的值；
 *      dp[i][0] = dp[i-1][0] + grid[i][0]，表示第一列的路径和只能从上方到达；
 *      dp[0][j] = dp[0][j-1] + grid[0][j]，表示第一行的路径和只能从左方到达；
 *      4. 返回值：dp[m-1][n-1]，表示到达右下角的最小路径和。
 * 时间复杂度：O(m*n)，空间复杂度：O(m*n)；
 */
public class Lc64 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // 初始化左上角
        dp[0][0] = grid[0][0];

        // 初始化第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // 初始化第一行
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}
