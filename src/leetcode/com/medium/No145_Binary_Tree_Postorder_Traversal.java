package leetcode.com.medium;

import leetcode.com.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jason on 2016/3/27.
 * Location：
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * ****************************************************************
 * Description：
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [3,2,1].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * *******************************************************************
 * Solution：
 * *******************************************************************
 * Hints:
 * http://blog.sina.com.cn/s/blog_eb52001d0102v1si.html
 */
public class No145_Binary_Tree_Postorder_Traversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) return rst;

        stack.push(root);
        if (root.right != null) stack.push(root.right);
        if (root.left != null) stack.push(root.left);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            rst.add(node.val);

            //bug:将root与node弄混
            if (node.right != null) stack.push(node.right);

            if (node.left != null) stack.push(node.left);
        }
        return rst;

    }
}
