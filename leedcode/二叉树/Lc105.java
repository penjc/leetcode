package leedcode.二叉树;

import java.util.*;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 题目描述：
 *      根据一棵树的前序遍历与中序遍历构造二叉树。
 * 解题思路：
 *      递归构建二叉树；
 *      前序遍历的第一个元素是根节点；
 *      在中序遍历中找到根节点的位置，左边是左子树，右边是右子树；
 */
public class Lc105 {

    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 建立一个map存储中序遍历的值到索引的映射
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preLeft, int preRight,
                           int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight) return null;

        // 根节点是前序遍历的第一个元素
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);

        // 找到根节点在中序遍历中的位置
        int inRootIndex = inorderIndexMap.get(rootVal);
        int leftSize = inRootIndex - inLeft;

        // 构建左子树
        root.left = build(preorder, preLeft + 1, preLeft + leftSize,
                inorder, inLeft, inRootIndex - 1);

        // 构建右子树
        root.right = build(preorder, preLeft + leftSize + 1, preRight,
                inorder, inRootIndex + 1, inRight);

        return root;
    }
}
