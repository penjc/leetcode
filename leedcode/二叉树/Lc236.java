package leedcode.二叉树;

/**
 * Lc236: 二叉树的最近公共祖先
 * 题目描述：
 *      给定一个二叉树，找到该树中两个指定节点的最近公共祖先。
 * 解题思路：
 *      递归
 *      如果当前节点为空，返回 null
 *      如果当前节点就是 p 或 q，直接返回当前节点
 *      否则，递归查找左子树和右子树：
 *          如果左子树和右子树都不为空，说明 p 和 q 分别位于当前节点两侧，此时当前节点就是最近公共祖先
 *          如果只有一边不为空，说明 p 和 q 都在这一侧，返回该非空子树的结果
 * 时间复杂度：O(n)，每个节点最多访问一次
 * 空间复杂度：O(h)，递归栈的深度，最坏为树的高度，h 为树的高度
 */
public class Lc236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) { // 左右都找到
            return root; // 当前节点是最近公共祖先
        }
        return left != null ? left : right;
    }
}
