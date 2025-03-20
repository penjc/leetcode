package leedcode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * 题目描述：
 *      给你一个二叉树，请你返回其按 层序遍历 得到的节点值。
 *      （即逐层地，从左到右访问所有节点）。
 * 解题思路：
 *      使用队列实现广度优先搜索
 *      从根节点开始，将根节点加入队列
 *      当队列不为空时，循环以下操作：
 *          记录当前层的节点数量 levelSize
 *          创建一个列表 currentLevel，用于存储当前层的节点值
 *          遍历 levelSize 次，将当前层的节点加入 currentLevel
 *          将当前层的节点值加入结果列表 result
 *      返回结果列表
 */
class Lc102 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // 使用队列来实现广度优先搜索
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // 当前层的节点数量
            List<Integer> currentLevel = new ArrayList<>();

            // 遍历当前层的所有节点
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.remove(); // 从队列中取出节点
                currentLevel.add(currentNode.val);

                // 将左子节点加入队列
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                // 将右子节点加入队列
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            // 将当前层加入结果列表
            result.add(currentLevel);
        }

        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);


        List<List<Integer>> result = levelOrder(root);

        // 输出层序遍历结果
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}