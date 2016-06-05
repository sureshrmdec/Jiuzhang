package leetcode.com.pickup1.hard;

import leetcode.com.util.ListNode;
import leetcode.com.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tclresearchamerica on 6/4/16.
 * ****************************************************
 * Location:
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * ****************************************************
 * Thoughts:
 * 1.if it requires the postorder, we'll need a data structure to keep the root element like stack FILO
 * 2.or recursive function to loop the elements ---
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 */
public class NO145_Binary_Tree_Postorder_Traversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();


        return resultList;
    }

    private void resursivePostOrder(TreeNode root, List<Integer> resultList) {
        if (root==null) return;
        resursivePostOrder(root.left,resultList);
        resursivePostOrder(root.left,resultList);

    }
}
