package leedcode100.滑动窗口;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
