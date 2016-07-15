package leetcode.com.pickup1.medium;

import leetcode.com.util.TreeNode;

/**
 * Created by tclresearchamerica on 7/14/16.
 * ****************************************************
 * Location:
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * ****************************************************
 * Description:
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * ****************************************************
 * Thoughts:
 * 1.postOrder的最后一项必然是root,那么每棵子树的root也在这个字数的最后一项,
 * 它的前一项必然是右子树的根?-->(不对,若无右子树,则结论不正确,需要inorder来佐证)
 * 2.Inorder:root切分了这棵子树的左右子树
 * 3.先找到postorder的最后一项,就是root,然后在inorder找到root,如果后面有这一项,那就是右子树,然后再在postorder中找
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 */
public class No106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) return null;

        int inEnd = inorder.length - 1;
        int postEnd = postorder.length - 1;

        TreeNode root = new TreeNode(postorder[postEnd]);

        TreeNode tmp = root;

        for (int i = postEnd - 1; i >= 0; i--) {
            for (int j = 0; j <= inEnd; j++) {
                if (inorder[i] == postorder[j]) {

                }
            }
        }

        return null;
    }
}
