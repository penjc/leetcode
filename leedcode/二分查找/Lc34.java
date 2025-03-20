package leedcode.二分查找;

/**
 * 34: 在排序数组中查找元素的第一个和最后一个位置
 * 题目描述：
 *      本题要求在排序数组中查找目标值 target 的第一个和最后一个位置，并要求时间复杂度为 O(log n)。
 *      由于数组是非递减排序的，我们可以使用二分查找（Binary Search）来高效地解决这个问题。
 * 解题思路：
 *      二分查找
 *      普通二分查找只能找到某个目标值的任意位置，但本题需要找到左边界和右边界，所以要进行两次二分查找：
 *      第一次二分查找：找第一个出现的位置（左边界）。
 *      第二次二分查找：找最后一个出现的位置（右边界）。
 * 复杂度分析：
 *      时间复杂度：O(log n)，二分查找的时间复杂度。
 *      空间复杂度：O(1)，只使用了常数个变量。
 */
public class Lc34 {

    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1}; // nums 中没有 target
        }
        // 如果 start 存在，那么 end 必定存在
        int end = lowerBound(nums, target + 1) - 1;
        return new int[]{start, end};
    }

    // lowerBound 返回最小的满足 nums[i] >= target 的下标 i
    // 如果数组为空，或者所有数都 < target，则返回 nums.length
    // 要求 nums 是非递减的，即 nums[i] <= nums[i + 1]
    private int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 闭区间 [left, right]
        while (left <= right) { // 区间不为空
            // 循环不变量：
            // nums[left-1] < target
            // nums[right+1] >= target
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1; // 范围缩小到 [left, mid-1]
            } else {
                left = mid + 1; // 范围缩小到 [mid+1, right]
            }
        }
        // 循环结束后 left = right+1
        // 此时 nums[left-1] < target 而 nums[left] = nums[right+1] >= target
        // 所以 left 就是第一个 >= target 的元素下标
        return left;
    }

}
