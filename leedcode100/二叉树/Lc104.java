package leedcode100.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 *      给定一棵二叉树 root，返回其 最大深度，即 从根节点到最远叶子节点的最长路径上的节点数。
 * 解题思路
 *      可以使用 递归 或 迭代（BFS 层序遍历） 解决。
 *      方法一：递归（DFS 深度优先遍历）
 *          若 root == null，则深度为 0
 *          递归求 左子树深度 和 右子树深度，取 最大值 +1
 *      方法二：迭代（BFS 层序遍历）
 *          使用 队列（Queue） 进行层序遍历
 *          每遍历一层，深度 +1
 */
public class Lc104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }

}
