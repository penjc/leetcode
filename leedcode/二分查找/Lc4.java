package leedcode.二分查找;

/**
 * 4. 寻找两个正序数组的中位数
 *      给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *      算法的时间复杂度应该为 O(log (m+n)) 。
 * 解题思路：
 *      二分查找（切割数组）
 *      我们采用二分查找 + 划分数组的方法：
 *      把较短的数组作为 nums1（保证 nums1 的长度 ≤ nums2）。
 *      在 nums1 上进行二分查找，找到合适的切割点 partitionX，使得：
 *          leftX (左部分的最大值) ≤ rightY (右部分的最小值)
 *          leftY (左部分的最大值) ≤ rightX (右部分的最小值)
 *      根据 partitionX 和 partitionY 计算中位数：
 *          如果 m + n 是奇数，中位数就是 max(leftX, leftY)。
 *          如果 m + n 是偶数，中位数是 (max(leftX, leftY) + min(rightX, rightY)) / 2。
 *      切割规则
 *          partitionX = (left + right) / 2
 *          partitionY = (m + n + 1) / 2 - partitionX
 */
public class Lc4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 确保 nums1 是较短的数组，以减少二分查找范围
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;
        int partitionX, partitionY;

        while (left <= right) {
            partitionX = left + (right - left) / 2;
            partitionY = (m + n + 1) / 2 - partitionX;

            // 定义左右边界
            int leftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int rightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            int leftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int rightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            // 满足中位数条件
            if (leftX <= rightY && leftY <= rightX) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(leftX, leftY) + Math.min(rightX, rightY)) / 2.0;
                } else {
                    return Math.max(leftX, leftY);
                }
            }
            // 说明 partitionX 选小了，增加 left
            else if (leftX > rightY) {
                right = partitionX - 1;
            }
            // 说明 partitionX 选大了，减少 right
            else {
                left = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Invalid input");
    }
}
