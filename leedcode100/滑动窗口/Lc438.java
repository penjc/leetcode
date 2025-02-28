package leedcode100.滑动窗口;

import java.util.*;

public class Lc438 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        // 统计 p 中字符的频率
        int[] pFreq = new int[26];
        for (char c : p.toCharArray()) {
            pFreq[c - 'a']++;
        }
        // 滑动窗口
        int[] windowFreq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            // 当前字符加入窗口
            windowFreq[s.charAt(i) - 'a']++;

            // 如果窗口大小大于 p 的大小，则滑动窗口
            if (i >= p.length()) {
                windowFreq[s.charAt(i - p.length()) - 'a']--;
            }

            // 如果窗口中的字符频率与 p 中的字符频率相同，则记录起始索引
            if (Arrays.equals(windowFreq, pFreq)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        List<Integer> result = findAnagrams(s, p);
        System.out.println(result);
    }
}
