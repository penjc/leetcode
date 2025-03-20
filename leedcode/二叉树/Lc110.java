package leedcode.二叉树;

/**
 * 110. 平衡二叉树
 * 题目描述：
 *      给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 解题思路：
 *      递归判断左右子树的高度差是否小于等于 1，且左右子树也是平衡二叉树。
 *      递归时，如果发现子树不平衡，则提前返回 -1。那么根节点只需要判断返回值是否为 -1 即可。
 */
public class Lc110 {

    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        int leftH = getHeight(node.left);
        if (leftH == -1) return -1; // 提前退出，不再递归
        int rightH = getHeight(node.right);
        if (rightH == -1 || Math.abs(leftH - rightH) > 1) return -1;
        return Math.max(leftH, rightH) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }


}
