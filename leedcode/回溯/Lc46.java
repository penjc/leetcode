package leedcode.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * Lc46: 全排列
 */
public class Lc46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> path, boolean[] used,
                           List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path)); // 拷贝当前排列
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // 跳过已使用

            path.add(nums[i]);
            used[i] = true;

            backtrack(nums, path, used, result);

            path.remove(path.size() - 1); // 撤销选择
            used[i] = false;
        }
    }
}
