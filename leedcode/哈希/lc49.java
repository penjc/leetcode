package leedcode.哈希;

import java.util.*;

public class lc49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // 创建一个哈希表，用于存储排序后的字母和对应的字母异位词列表
        Map<String, List<String>> map = new HashMap<>();

        // 遍历所有单词
        for (String str : strs) {
            // 将单词的字母排序，作为哈希表的键
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            // 如果哈希表中已存在该排序后的字母，则将当前单词加入对应的列表中
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }

            map.get(sortedStr).add(str);
        }

        // 返回哈希表中的所有字母异位词分组
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        // 示例输入
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] strs = input.split(" ");

        // 调用groupAnagrams方法
        List<List<String>> result = groupAnagrams(strs);

        // 输出结果
        System.out.println(result);
    }
}

