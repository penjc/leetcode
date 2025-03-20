package leedcode.排序;

import java.util.Random;

/**
 * Lc912: 排序数组
 * https://leetcode-cn.com/problems/sort-an-array/
 */
public class Lc912 {
    public int[] sortArray(int[] nums) {
        if (nums == null)
            return null;

        int right = nums.length - 1;
        quickSort(nums, 0, right);
        return nums;
    }

    private static final Random rand = new Random();

    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int p = randomizedPartition(nums, left, right);
            quickSort(nums, left, p - 1);
            quickSort(nums, p + 1, right);
        }
    }

    private static int randomizedPartition(int[] nums, int low, int high) {
        int pivotIndex = low + rand.nextInt(high - low + 1);
        swap(nums, pivotIndex, high);
        return partition(nums, low, high);
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if(nums[j] < pivot){
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
