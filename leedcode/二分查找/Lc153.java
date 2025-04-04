package leedcode.二分查找;

/**
 * Lc153: 寻找旋转排序数组中的最小值
 * 题目描述：
 *      我们有一个原本升序的数组 nums，但经过了若干次旋转。我们需要在 O(log n) 的时间复杂度内找到数组的最小元素。
 *      旋转后，数组可以被分为两个递增的部分，其中第二部分的第一个元素就是最小值。(数组的第一个元素大于最后一个元素）
 * 解题思路：
 *      如果 nums[mid] > nums[right]，说明最小值在右侧（mid 在左侧递增部分），移动 left = mid + 1。
 *      如果 nums[mid] < nums[right]，说明最小值在左侧或 mid 自己就是最小值，移动 right = mid。
 *      终止条件：当 left == right 时，该位置即为最小值。
 */
public class Lc153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
