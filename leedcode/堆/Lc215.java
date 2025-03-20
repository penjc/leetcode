package leedcode.堆;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Lc215: 数组中的第K个最大元素
 * 题目描述：
 *      在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，
 * 解题思路：
 *      使用最小堆
 *      如果堆的大小不超过 k，直接插入。
 *      如果堆的大小超过 k，移除堆顶（最小元素），保证堆只存 k 个最大的数。
 */
public class Lc215 {

    public int findKthLargest(int[] nums, int k) {
        // 1. 创建一个最小堆，堆中最多存 k 个元素
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // 2. 遍历数组，保持堆的大小为 k
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // 移除堆顶（最小的元素）
            }
        }

        // 3. 堆顶即为第 k 大的元素
        return minHeap.peek();
    }



    private static final Random rand = new Random();

    // 快速选择 - 随机化快排 根据返回的索引 p 与 k 的大小关系，决定继续搜索左边还是右边
    public int findKthLargest2(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        int targetIndex = k - 1; // 第 k 大的索引

        while (low <= high) {
            int p = randomizedPartition(nums, low, high);

            if (p == targetIndex) {
                return nums[p];
            } else if (p > targetIndex) {
                high = p - 1; // 搜索左侧
            } else {
                low = p + 1; // 搜索右侧
            }
        }
        return -1;
    }

    private int randomizedPartition(int[] nums, int low, int high) {
        int pivotIndex = low + rand.nextInt(high - low + 1); // 🎯 随机选 pivot
        swap(nums, pivotIndex, high); // 交换 pivot 和最后一个元素
        return partition(nums, low, high);
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (nums[j] > pivot) { // 🎯 保持大数在左侧
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, high); // 🎯 pivot 归位
        return i; // 返回 pivot 的索引
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
