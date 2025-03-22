package leedcode.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * Lc78: 子集
 * 题目描述：
 *      给定一个不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *      解集不能包含重复的子集。
 * 解题思路：
 *      回溯
 *
 */
class Lc78 {
    List<List<Integer>> result = new ArrayList<>();  // 保存最终所有子集
    List<Integer> path = new ArrayList<>();          // 当前子集路径

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);                          // 从第0个数开始处理
        return result;
    }

    private void backtrack(int[] nums, int start) {
        result.add(new ArrayList<>(path));           // 当前路径加入结果（无论选了几个）

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);                       // 选择nums[i]
            backtrack(nums, i + 1);                  // 递归处理下一个数（只能往后，防止重复）
            path.remove(path.size() - 1);            // 回溯：撤销选择
        }
    }
}
