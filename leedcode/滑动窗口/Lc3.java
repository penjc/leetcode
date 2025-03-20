package leedcode.滑动窗口;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 题目描述：
 *      给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * 解题思路：
 *      滑动窗口（双指针 + HashSet）
 *      使用 双指针（left, right） 和 HashSet 记录窗口内字符，维护一个 滑动窗口：
 *          扩展右指针 right：
 *              如果 s[right] 不在 Set 中，加入 Set，更新最大长度 maxLength。
 *              如果 s[right] 已存在，移动左指针 left，直到 s[right] 不在窗口内，确保窗口内无重复字符。
 *          持续移动 right 指针 直到遍历完整个字符串。
 *      时间复杂度分析
 *          每个字符最多被访问两次（一次加入 Set，一次移出 Set），所以 时间复杂度 O(n)。
 */

public class Lc3 {
    public static int lengthOfLongestSubstring(String s) {
        // 定义两个指针，left为窗口的左边界，right为右边界
        int left = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        // 遍历字符串
        for (int right = 0; right < s.length(); right++) {
            // 如果当前字符已经在集合中，收缩窗口，直到去掉重复字符
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            // 将当前字符加入窗口
            set.add(s.charAt(right));
            // 更新最大长度
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String nextLine = sc.nextLine();
        System.out.println(lengthOfLongestSubstring(nextLine));
    }
}
