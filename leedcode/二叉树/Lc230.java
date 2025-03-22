package leedcode.二叉树;

/**
 * Lc230: 二叉搜索树中第 K 小的元素
 * 题目描述：
 *      给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 解题思路：
 *      二叉搜索树的中序遍历是升序序列，因此可以通过中序遍历找到第 k 个最小的元素。
 * 时间复杂度：O(n)，每个节点最多访问一次
 */
public class Lc230 {
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return result;
    }

    private void inOrder(TreeNode node, int k) {
        if (node == null) return;

        inOrder(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        inOrder(node.right, k);
    }
}
