package leedcode100.二叉树;

/**
 * 101. 对称二叉树
 * 题目描述：
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class Lc101 {
    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left, root.right);
    }

    // 在【100. 相同的树】的基础上稍加改动
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val && isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }


}
