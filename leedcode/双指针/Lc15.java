package leedcode.双指针;

import java.util.*;

/**
 * 15. 三数之和
 * 题目描述：
 *      本题要求找到数组 nums 中所有和为 0 的三元组 [nums[i], nums[j], nums[k]]，并确保：
 *      不能有重复三元组
 *      i, j, k 互不相同
 *      最终返回的结果不能有重复的组合
 * 解题思路：
 *      排序 nums：确保数组有序，方便去重。
 *      遍历数组：
 *          固定 nums[i] 作为三元组的第一个元素；
 *          在 nums[i+1] 到 nums[n-1] 之间，使用双指针 left 和 right 查找两个数，使它们的和等于 -nums[i]。
 *      双指针查找
 *          计算 nums[i] + nums[left] + nums[right] 的值：
 *          如果和为 0：记录结果，并跳过重复元素。
 *          如果和小于 0：left++（需要更大的数）。
 *          如果和大于 0：right--（需要更小的数）。
 *      去重处理
 *          外层循环：如果 nums[i] == nums[i-1]，则跳过（避免重复的三元组）。
 *          内层指针移动：当 nums[left] == nums[left+1] 或 nums[right] == nums[right-1]，继续移动指针。
 * 复杂度分析
 * 排序 O(n log n)
 * 遍历 + 双指针查找 O(n²)
 * 总体复杂度 O(n²)
 */
public class Lc15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 如果数组长度小于3，直接返回空
        if (nums == null || nums.length < 3) {
            return result;
        }

        // 排序数组
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过重复元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 双指针法
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // 找到一个三元组，添加到结果中
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 跳过重复的左指针和右指针元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // 移动指针
                    left++;
                    right--;
                } else if (sum < 0) {
                    // 如果和小于0，左指针右移
                    left++;
                } else {
                    // 如果和大于0，右指针左移
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nextLine = sc.nextLine();
        String[] s = nextLine.split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }
}
