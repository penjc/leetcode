package leedcode.二分查找;

/**
 * Lc162: 寻找峰值
 * 题目描述：
 *      本题要求找到数组中的峰值元素，并返回其索引。峰值的定义是：
 *          nums[i] 严格大于 相邻元素 nums[i-1] 和 nums[i+1]。
 *      题目还提供了两个特殊条件：
 *          设定 nums[-1] = -∞ 和 nums[n] = -∞，即数组边界外的值都是负无穷。
 *          数组可能包含多个峰值，我们可以返回任意一个峰值的索引。
 * 解题思路：
 *      利用二分查找寻找峰值：
 *      取数组的中点 mid。
 *      比较 mid 和 mid+1：
 *          如果 nums[mid] > nums[mid+1]，说明左侧可能存在峰值，移动 right = mid。
 *          如果 nums[mid] < nums[mid+1]，说明右侧必然有峰值，移动 left = mid + 1。
 *      继续二分查找，直到 left == right，此时 left 就是峰值位置。
 */
public class Lc162 {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 2;
        while (l <= r) {
            int mid = l +  (r - l) / 2;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
