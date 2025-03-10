package leedcode100.普通数组;

/**
 * 题目描述：
 *      给你一个整数数组 nums，返回一个数组 answer，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 要求：
 *      不能使用除法。
 *      必须在 O(n) 时间复杂度内完成。
 * 解题思路：
 * 使用 前缀积（prefix）和后缀积（suffix） 来解决问题：
 *      构造 prefix[i]：表示 nums[0] 到 nums[i-1] 的乘积（不包括 nums[i]）。
 *      构造 suffix[i]：表示 nums[i+1] 到 nums[n-1] 的乘积（不包括 nums[i]）。
 *      最终结果：answer[i] = prefix[i] * suffix[i]。
 */
public class Lc238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // 1. 计算前缀积
        answer[0] = 1; // 第一个元素左侧没有数，因此为 1
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // 2. 计算后缀积，并直接更新 answer
        int suffix = 1; // 记录后缀积
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffix;
            suffix *= nums[i]; // 更新后缀积
        }

        return answer;
    }
}
