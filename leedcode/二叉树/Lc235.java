package leedcode.二叉树;

/**
 * Lc235: 二叉搜索树的最近公共祖先
 * 题目描述：
 *      给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 解题思路：
 *      如果 p.val < node.val 且 q.val < node.val，则最近公共祖先一定在左子树；
 *      如果 p.val > node.val 且 q.val > node.val，则最近公共祖先一定在右子树；
 *      否则，node 就是最近公共祖先（p 和 q 分别在两边，或者其中之一就是当前节点）。
 * 时间复杂度：O(n)，每个节点最多访问一次
 * 空间复杂度：O(h)，递归栈的深度，最坏为树的高度，h 为树的高度
 */
public class Lc235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int x = root.val;
        if (p.val < x && q.val < x) { // p 和 q 都在左子树
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > x && q.val > x) { // p 和 q 都在右子树
            return lowestCommonAncestor(root.right, p, q);
        }
        return root; // 其它
    }
}
