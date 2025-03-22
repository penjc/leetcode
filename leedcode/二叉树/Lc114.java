package leedcode.二叉树;

/**
 * Lc114: 二叉树展开为链表
 * 题目描述：
 *      给定一个二叉树，原地将它展开为一个单链表。
 * 解题思路：
 *      使用后序遍历的逆过程（先右，再左，最后根）；
 *      每访问一个节点，就把它的右指针指向上一个访问的节点；
 *      用一个 prev 指针记录上一个访问的节点。
 * 时间复杂度：O(n)，每个节点最多访问一次
 */
public class Lc114 {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}
