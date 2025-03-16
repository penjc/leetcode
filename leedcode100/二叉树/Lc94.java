package leedcode100.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目描述：
 *      给定一个二叉树的根节点 root，返回它的 中序遍历（Inorder Traversal）。
 *      中序遍历规则：左子树 → 根节点 → 右子树
 * 解题思路：
 * 有三种方法可以实现 二叉树的中序遍历：
 * 递归方式（最直观的方式）
 * 迭代方式（使用栈）
 */
public class Lc94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
}
