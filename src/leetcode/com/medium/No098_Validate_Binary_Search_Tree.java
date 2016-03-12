package leetcode.com.medium;

/**
 * Created by jason on 2016/3/11.
 * Location:
 * https://leetcode.com/problems/validate-binary-search-tree/
 * ************************************************************
 * Description:
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees
 * *************************************************************
 * Solution:
 * Traverse: 遍历的很巧妙很有意思，关键要标出最左子节点
 */
public class No098_Validate_Binary_Search_Tree {
    private int lastVal = Integer.MIN_VALUE;
    private boolean firstNode = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (!(isValidBST(root.left))) return false;

        if (!firstNode && lastVal >= root.val) return false;

        firstNode = false;
        lastVal = root.val;
        return isValidBST(root.right);
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
