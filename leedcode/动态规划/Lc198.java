package leedcode.动态规划;

/**
 * Lc198: 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 * 题目描述：
 *    你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都存放着一定金额的现金，
 * 解题思路：
 *    动态规划
 */
public class Lc198 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = nums[0]; // dp[i - 2]
        int prev1 = Math.max(nums[0], nums[1]); // dp[i - 1]

        for (int i = 2; i < nums.length; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
