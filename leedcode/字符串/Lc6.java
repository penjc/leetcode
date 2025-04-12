package leedcode.字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * Lc6: Z 字形变换
 * 题目描述：
 *      将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 解题思路：
 *      1. 创建一个 StringBuilder 数组，长度为 numRows。
 *      2. 遍历字符串，将每个字符添加到对应的 StringBuilder 中。
 *      3. 使用一个变量 i 来表示当前行，另一个变量 flag 来控制行的方向（向下或向上）。
 *      4. 当到达第一行或最后一行时，改变 flag 的值，改变方向。
 *      5. 最后，将所有 StringBuilder 中的内容拼接起来，返回结果。
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class Lc6 {
    public String convert(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}
