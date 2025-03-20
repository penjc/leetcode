package leedcode.双指针;

/**
 * 接雨水
 * 题目描述：
 *      给定一个数组 height，其中 height[i] 表示第 i 根柱子的高度。柱子的宽度为 1，我们需要计算柱子之间可以接多少雨水。
 * 解题思路：
 *      动态编程（前缀最大 + 后缀最大）
 *          预计算 左侧最高数组 leftMax[] 和 右侧最高数组 rightMax[]。
 *          遍历 height 数组，计算每个柱子的积水量：water=min(leftMax[i],rightMax[i])−height[i]
 *          求和即为答案。
 *          时间复杂度：O(n)（遍历三次）
 *          空间复杂度：O(n)（存储 leftMax[] 和 rightMax[]）
 *      双指针优化
 *          由于 leftMax[i] 只依赖 leftMax[i-1]，rightMax[i] 只依赖 rightMax[i+1]，所以可以用双指针来优化空间：
 *          设定 left 和 right 指针分别指向数组的两端。
 *          用 leftMax 记录 left 位置的最大值，用 rightMax 记录 right 位置的最大值。
 *          从左右两侧向中间收缩：
 *              如果 leftMax < rightMax，则 left 位置的存水量由 leftMax 决定，并移动 left。
 *              如果 leftMax ≥ rightMax，则 right 位置的存水量由 rightMax 决定，并移动 right。
 *          时间复杂度：O(n)（遍历一次）
 *          空间复杂度：O(1)（只使用几个变量）
 *
 *
 */
public class Lc42 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int totalWater = 0;

        // 计算左侧最大高度
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // 计算右侧最大高度
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // 计算总积水量
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return totalWater;
    }

    public int trap2(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }

        return totalWater;
    }
}
