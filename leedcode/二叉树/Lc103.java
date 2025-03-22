package leedcode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Lc103: 二叉树的锯齿形层序遍历
 * 题目描述：
 *      给定一个二叉树，返回其节点值的锯齿形层序遍历。
 * 时间复杂度：O(n)，每个节点最多访问一次
 * 空间复杂度：O(n)，队列的空间
 */
public class Lc103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true; // 第一层从左到右

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (leftToRight) {
                    level.addLast(node.val);  // 从左到右
                } else {
                    level.addFirst(node.val); // 从右到左
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(level);
            leftToRight = !leftToRight; // 下一层反转方向
        }

        return result;
    }
}
