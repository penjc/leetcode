package leedcode.哈希;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 128. 最长连续序列
 * 题目描述：
 *      给定一个未排序的整数数组 nums，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 解题思路：
 * 使用 HashSet
 * 由于查找某个数是否存在的操作在 哈希表（HashSet） 中是 O(1) 时间复杂度，我们可以利用 HashSet 来高效地寻找最长连续序列。
 *      构建哈希集合（Set）：
 *          先将所有 nums 中的数放入 HashSet，以便快速查找某个数是否存在。
 *      寻找连续序列的起点：
 *          遍历 nums，对每个数 x，检查 x-1 是否在 Set 中。
 *          如果 x-1 存在，说明 x 不是序列的起点，跳过。
 *          如果 x-1 不存在，说明 x 是新的序列起点，我们开始找 x+1, x+2, ... 的连续序列长度。
 *      更新最长长度：
 *          从 x 开始，查找 x+1, x+2, ... 是否存在于 Set，计算当前连续序列长度 curLength。
 *          维护 maxLength，更新最长的连续序列长度。
 */
public class lc128 {
    public static int longestConsecutive(int[] nums) {
        // 使用哈希集合存储所有的数字
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // 遍历每个数字
        for (int num : numSet) {
            // 判断当前数字是否为连续序列的起点
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // 向后查找连续的数字
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                // 更新最长序列长度
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nextLine = sc.nextLine();
        String[] s = nextLine.split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }

        int result = longestConsecutive(nums);
        System.out.println(result);
    }
}
