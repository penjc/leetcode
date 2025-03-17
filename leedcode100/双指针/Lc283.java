package leedcode100.双指针;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 283. 移动零
 * 题目描述：
 *      给定一个整数数组 nums，要求：
 *      将所有 0 移动到数组末尾。
 *      保持非零元素的相对顺序。
 *      必须原地修改，不能使用额外的数组存储结果。
 * 解题思路：
 *      双指针（O(n) 时间，O(1) 空间）
 *      使用双指针方法，一个指针遍历数组，另一个指针用来放置非零元素：
 *      fast 指针用于遍历数组。
 *      slow 指针用于指向非零元素应该放置的位置。
 *          使用 fast 遍历 nums，遇到非零元素时，将其赋值给 slow 指向的位置，并 slow++。
 *          遍历完成后，slow 之前的部分已经全部是非零元素。
 *          让 slow 及其之后的所有元素赋值为 0。
 * 复杂度分析
 * 时间复杂度：O(n)，仅遍历了一次数组。
 * 空间复杂度：O(1)，仅使用了常数额外变量。
 */
public class Lc283 {

    public static void moveZeroes(int[] nums) {
        int slow = 0; // 慢指针，指向下一个非零元素应该放置的位置

        // 1. 遍历数组，将所有非零元素按顺序放到数组前面
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }

        // 2. 将 slow 之后的元素全部置为 0
        while (slow < nums.length) {
            nums[slow++] = 0;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String nextLine = sc.nextLine();
        String[] s = nextLine.split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
