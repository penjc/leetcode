package leedcode100.哈希;

import java.util.HashSet;
import java.util.Scanner;

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
