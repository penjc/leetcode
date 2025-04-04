package leedcode.多维动态规划;

/**
 * 1143. 最长公共子序列
 * 题目描述：
 *      给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * 解题思路：
 *      动态规划
 *      定义 dp[i][j] 为 text1 的前 i 个字符和 text2 的前 j 个字符的最长公共子序列的长度。
 *      状态转移方程：
 *      if (text1[i - 1] == text2[j - 1]) {
 *      dp[i][j] = dp[i - 1][j - 1] + 1;
 *      } else {
 *      dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
 *      }
 *      初始化 dp 数组，dp[0][j] = 0, dp[i][0] = 0
 *      最后返回 dp[m][n] 即可
 * 时间复杂度：O(m * n)
 */
public class Lc1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1]; // 多开一行一列用于边界处理

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
