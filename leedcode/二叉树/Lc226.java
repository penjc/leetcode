package leedcode.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 *          给定一棵二叉树的根节点 root，翻转 这棵二叉树（即左右子树交换），然后返回翻转后的 根节点。
 *          解题思路
 *          可以使用 递归（DFS） 和 迭代（BFS） 方式进行翻转。
 *              方法 1：递归（DFS）
 *                  递归交换每个节点的左右子树
 *                  终止条件：root == null 时返回 null
 *                  递归处理 root.left 和 root.right
 *                  交换 left 和 right
 *              方法 2：迭代（BFS - 层序遍历）
 *                  用 队列 进行 层序遍历
 *                  每次取出 当前节点，交换 左右子树
 *                  将 左右子树 加入队列，直到遍历结束
 */
public class Lc226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // 递归翻转左右子树
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // 交换
        root.left = right;
        root.right = left;

        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }

}
