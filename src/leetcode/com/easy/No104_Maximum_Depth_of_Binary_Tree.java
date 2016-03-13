package leetcode.com.easy;

/**
 * Created by jason on 2016/3/12.
 * Location:
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * **************************************************
 * Description:
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * **************************************************
 * Solution:
 * 使用标准的递归模板
 * **************************************************
 * Bugs：
 * 要设置临时变量，不要对左右两节点做重复扫描，要认识到递归函数的使用方法，它不是变量，没有记忆化搜索
 */
public class No104_Maximum_Depth_of_Binary_Tree {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDeep = maxDepth(root.left);
        int rightDeep = maxDepth(root.right);

        return 1 + Math.max(leftDeep, rightDeep);

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
