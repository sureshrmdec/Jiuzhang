package leetcode.com.easy;

/**
 * Created by jason on 2016/2/24.
 * Location:
 * ******************************************
 * Description:
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * ******************************************
 * Solution:
 * 递归调用，循环处理
 */
public class No100_Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return check(p, q);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return check(p.left, q.left)&&check(p.right, q.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
