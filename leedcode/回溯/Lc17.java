package leedcode.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * Lc17: 电话号码的字母组合
 * 题目描述：
 *      给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 解题思路：
 *      回溯法
 *      1. 递归的定义：递归的定义是，从 digits[i] 开始的所有组合，放到 path 中
 *      2. 递归的出口：当 i == digits.length 时，说明 digits 中的所有数字已经处理完了，将 path 放到结果集中
 *      3. 递归的拆解：对于 digits[i]，遍历其对应的所有字母，放到 path 中，然后递归处理 digits[i+1]
 * 时间复杂度：O(3^m * 4^n)，其中 m 是输入中对应 3 个字母的数字个数，n 是输入中对应 4 个字母的数字个数
 */
public class Lc17 {

    private static final String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private final List<String> ans = new ArrayList<>();
    private char[] digits;
    private char[] path;

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) {
            return ans;
        }
        this.digits = digits.toCharArray();
        path = new char[n]; // 注意 path 长度一开始就是 n，不是空数组
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == digits.length) {
            ans.add(new String(path));
            return;
        }
        for (char c : MAPPING[digits[i] - '0'].toCharArray()) {
            path[i] = c; // 直接覆盖
            dfs(i + 1);
        }
    }
}
