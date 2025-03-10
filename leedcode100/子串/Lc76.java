package leedcode100.子串;

import java.util.HashMap;

/**
 * 用一个哈希表 need 记录 t 中字符的需求：
 *      need 记录 t 中每个字符的出现次数。
 *      window 记录当前窗口中已匹配的字符及其出现次数。
 * 滑动窗口机制：
 *      右指针 right 扩展窗口，增加字符，直到窗口包含 t 中所有字符。
 *      左指针 left 收缩窗口，尝试移除多余字符，保证子串最短。
 * 在每次满足条件后，更新最小子串的长度，最终返回最小子串。
 */
public class Lc76 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // 记录 t 中字符的需求
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 记录窗口内的字符
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0; // 窗口的左右边界
        int valid = 0;  // 记录窗口中满足 need 条件的字符个数
        int minLen = Integer.MAX_VALUE;
        int start = 0;  // 记录最小子串的起始位置

        while (right < s.length()) {
            char c = s.charAt(right); // 取出右指针指向的字符
            right++; // 扩展窗口

            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 当窗口满足条件时，尝试收缩窗口
            while (valid == need.size()) {
                // 更新最小覆盖子串
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char d = s.charAt(left);
                left++; // 收缩窗口

                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        // 返回最小覆盖子串
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
