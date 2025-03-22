package leedcode.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Lc513: 找树左下角的值
 * 题目描述：
 *     给定一个二叉树，在树的最后一行找到最左边的值。
 * 解题思路：
 *     BFS 这棵二叉树，先把右儿子入队，再把左儿子入队，这样最后一个出队的节点就是左下角的节点了。
 */
public class Lc513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) {
                queue.offer(root.right);
            }
            if (root.left != null) {
                queue.offer(root.left);
            }
        }
        return root.val;
    }
}
