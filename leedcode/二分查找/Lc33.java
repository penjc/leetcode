package leedcode.二分查找;

/**
 * 33. 搜索旋转排序数组
 * 题目描述：
 *      本题要求在旋转排序数组 nums 中搜索 target，并返回它的索引。如果 target 不存在，则返回 -1。
 * 解题思路：
 *      二分查找
 *      二分查找的关键在于判断 mid 落在哪个有序部分
 *      计算 mid = (left + right) / 2，然后判断：
 *          如果 nums[mid] == target，直接返回 mid。
 *      判断 mid 处于左半部分（升序）还是右半部分（升序）：
 *          左半部分有序 (nums[left] ≤ nums[mid])：
 *              如果 target 在 nums[left] 和 nums[mid] 之间，搜索左侧 (right = mid - 1)。
 *              否则，搜索右侧 (left = mid + 1)。
 *          右半部分有序 (nums[mid] ≤ nums[right])：
 *              如果 target 在 nums[mid] 和 nums[right] 之间，搜索右侧 (left = mid + 1)。
 *              否则，搜索左侧 (right = mid - 1)。
 */
public class Lc33 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 找到目标值
            if (nums[mid] == target) return mid;

            // 判断左半部分是否有序
            if (nums[left] <= nums[mid]) {
                // target 在左侧范围内
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else { // 否则在右侧
                    left = mid + 1;
                }
            }
            // 否则右半部分一定有序
            else {
                // target 在右侧范围内
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else { // 否则在左侧
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
