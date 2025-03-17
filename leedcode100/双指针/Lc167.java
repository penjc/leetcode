package leedcode100.双指针;

/**
 * 167. 两数之和 II - 输入有序数组
 * 题目描述：
 *      本题要求在一个有序数组中找到两个数，使它们的和等于给定的目标值 target，并返回它们的下标（下标从 1 开始计数）。我们需要遵守以下限制：
 *      只能使用常量级的额外空间，即不能使用哈希表等额外存储；
 *      只能有唯一解，不需要考虑多解情况；
 *      数组已按非递减顺序排列，可以利用这个性质优化查找。
 * 解题思路：
 * 由于数组已经排序，我们可以利用双指针技巧，以 O(n) 的时间复杂度找到解：
 *      设定两个指针：
 *          左指针（left）: 初始指向数组的第一个元素 (numbers[0])；
 *          右指针（right）: 初始指向数组的最后一个元素 (numbers[n-1])；
 *      计算当前两个指针对应元素的和：
 *          如果 sum == target：返回索引（注意题目要求是 1-based index）；
 *          如果 sum < target：说明当前和太小，需要增加和值，所以移动左指针 left++；
 *          如果 sum > target：说明当前和太大，需要减小和值，所以移动右指针 right--；
 *      继续以上过程，直到找到解。
 * 复杂度分析
 * 时间复杂度：O(n)，每个元素最多被访问一次（指针从两端向中间靠拢）。
 * 空间复杂度：O(1)，只使用了两个指针，不占额外空间。
 */
public class Lc167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1}; // 题目要求返回 1-based index
            } else if (sum < target) {
                left++;  // 需要更大的数
            } else {
                right--; // 需要更小的数
            }
        }
        return new int[]{-1, -1}; // 题目保证有解，这行代码不会执行
    }
}
