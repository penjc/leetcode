package leedcode.普通数组;

/**
 * dp[i] 表示 以 nums[i] 结尾的最大子数组和。
 *      dp[i]=max(dp[i−1]+nums[i],nums[i])
 *      dp[i-1] + nums[i]：将 nums[i] 加入前一个子数组，扩大和。nums[i]：重新开始一个子数组。
 *      取 max(dp[i]) 作为最终答案。
 * dp[i] 只和 dp[i-1] 相关，可以用 一个变量 curMax 代替 dp[i]。
 */
public class Lc53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int curMax = nums[0]; // 当前最大子数组和
        int globalMax = nums[0]; // 记录全局最大子数组和

        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]); // 递推公式
            System.out.println("curMax: " + curMax);
            globalMax = Math.max(globalMax, curMax); // 记录全局最大值
        }

        return globalMax;
    }

    public static void main(String[] args) {
        Lc53 solution = new Lc53();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray(nums));
    }
}
