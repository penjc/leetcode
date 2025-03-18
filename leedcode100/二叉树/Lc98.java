package leedcode100.二叉树;

/**
 * Lc98: 验证二叉搜索树
 * 题目描述：
 *      给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 解题思路：
 *      1. 前序遍历
 *      递归判断左右子树是否是二叉搜索树，同时需要判断当前节点是否满足二叉搜索树的条件。
 *      每个节点通过边界值来判断是否是二叉搜索树。
 *      2. 中序遍历
 */
public class Lc98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//        return inorder(root);
    }

    // 前序遍历
    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;

        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    // 中序遍历
    private TreeNode prev = null;

    private boolean inorder(TreeNode node) {
        if (node == null) return true;

        // 递归访问左子树
        if (!inorder(node.left)) return false;

        // 检查当前节点是否大于前一个节点
        if (prev != null && node.val <= prev.val) return false;
        prev = node; // 更新前一个节点

        // 递归访问右子树
        return inorder(node.right);
    }
}
