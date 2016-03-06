package leetcode.com.easy;

/**
 * Created by jason on 2016/2/24.
 * https://leetcode.com/problems/symmetric-tree/
 * ***********************************************
 * Description
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * ****************************************************
 * Solution：
 * 就是不断地循环递归判断左右两个子树的结构和value是否相等,
 * ****************************************************
 * Tips：
 * 对称的方式是中间对称哦
 *
 */
public class No101_Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        if (root==null)
            return true;
        return check(root.left,root.right);
    }

    private boolean check(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if (left==null || right==null){
            return false;
        }
        if (left.val!=right.val){
            return false;
        }
        return check(left.left,right.right)&&check(right.left,left.right);
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
