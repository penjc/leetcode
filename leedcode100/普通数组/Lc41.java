package leedcode100.普通数组;

/**
 * 题目描述
 *      给定一个 未排序 的整数数组 nums，找出其中 没有出现的最小的正整数。
 * 要求：
 *      时间复杂度 O(n)
 *      空间复杂度 O(1)（只能使用常数级别额外空间）
 *
 * 解题思路：
 *      遍历 nums 数组，把每个数放到正确的位置：
 *          如果 nums[i] 在 [1, n] 范围内，且 nums[i] 还没有在正确的位置上 nums[nums[i] - 1]，就交换它的位置。
 *          例如：nums[i] = 3，那么它应该放到 nums[2]（即索引 2 位置）。
 *      再次遍历 nums：
 *          找到第一个 nums[i] != i + 1 的位置，i + 1 就是答案。
 *      如果所有数都在正确的位置，说明缺失的是 n + 1，返回 n + 1。
 */
public class Lc41 {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;

            // Step 1: 交换，使得 nums[i] 放在 nums[i] - 1 位置上
            for (int i = 0; i < n; i++) {
                while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                    swap(nums, i, nums[i] - 1);
                }
            }

            // Step 2: 找到第一个 nums[i] != i + 1 的位置
            for (int i = 0; i < n; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }

            // Step 3: 如果全部正确，返回 n + 1
            return n + 1;
        }

        // 交换 nums[i] 和 nums[j]
        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
}
