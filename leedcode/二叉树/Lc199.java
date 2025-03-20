package leedcode.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * 题目描述：
 *      给定一个二叉树，想象自己站在它的右侧，返回从顶部到底部看到的节点值。
 * 解题思路：
 *      递归
 *      使用 DFS（深度优先搜索），每次优先访问右子树，这样确保我们优先看到右侧节点。
 *      如果当前深度等于结果集大小，说明是该层第一个访问的节点（右侧优先）。
 */
public class Lc199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int depth, List<Integer> result) {
        if (node == null) return;

        // 如果当前深度等于结果集大小，说明是该层第一个访问的节点（右侧优先）
        if (depth == result.size()) {
            result.add(node.val);
        }

        // 先访问右子树，再访问左子树
        dfs(node.right, depth + 1, result);
        dfs(node.left, depth + 1, result);
    }
}
