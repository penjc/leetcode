package leedcode100.普通数组;

import java.util.Arrays;

/**
 * author peng
 * description
 * date 2025/3/10
 */
public class Lc189 {

    /**
     * 新建一个数组 newArr，将 nums[i] 放到 newArr[(i + k) % n]。
     * 最后拷贝回 nums。
     */
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];

        // 放置到新位置
        for (int i = 0; i < n; i++) {
            newArr[(i + k) % n] = nums[i];
        }

        // 复制回原数组
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    /**
     * 整体翻转：反转整个数组 nums。
     * 反转前 k 个元素：恢复前 k 部分的顺序。
     * 反转后 n-k 个元素：恢复后 n-k 部分的顺序。
     */
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k %= n; // 避免 k 超过数组长度

        reverse(nums, 0, n - 1); // 1. 翻转整个数组
        reverse(nums, 0, k - 1); // 2. 翻转前 k 个元素
        reverse(nums, k, n - 1); // 3. 翻转后 n-k 个元素
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

}
