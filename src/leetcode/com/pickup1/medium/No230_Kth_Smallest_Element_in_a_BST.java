package leetcode.com.pickup1.medium;

import leetcode.com.util.TreeNode;

import java.util.Stack;

/**
 * Created by tclresearchamerica on 7/16/16.
 * ****************************************************
 * Location:
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * ****************************************************
 * Description:
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 * ****************************************************
 * Thought:
 * 1.开始的时候,没有想到答案,后来看了答案才知道该怎么整,其实自己是可以搞定的,就是中序遍历,先让最小的进去,然后是根,最后是右子树
 * 2.递归的写法比较简单,但是想尝试while循环的方式
 * 它是先一路向左压入栈中,然后出栈,然后压入右节点,然后继续压入左节点
 * ref:
 * https://segmentfault.com/a/1190000003704692
 * ****************************************************
 * 后续 Follow Up
 * 这题的难点其实在于Follow Up：如果我们频繁的操作该树，并且频繁的调用kth函数，有什么优化方法使时间复杂度降低至O(h)？h是树的高度。
 * 根据提示，我们可以在TreeNode中加入一个rank成员，这个变量记录的是该节点的左子树中节点的个数，其实就是有多少个节点比该节点小。
 * 这样我们就可以用二叉树搜索的方法来解决这个问题了。这个添加rank的操作可以在建树的时候一起完成。
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
public class No230_Kth_Smallest_Element_in_a_BST {
    Stack<TreeNode> stack = new Stack<>();

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        while (root != null) {
            s.push(root);
            root = root.left;
        }

        while (!s.isEmpty()) {
            TreeNode curt = s.pop();
            k--;
            if (k == 0) return curt.val;
            curt = curt.right;
            while (curt != null) {
                s.push(curt);
                curt = curt.left;
            }
        }
        return 0;
    }

    public int kthSmallest_zj(TreeNode root, int k) {
        helper(root, k);
        if (stack.size() == k) return stack.peek().val;
        return -1;
    }

    private void helper(TreeNode root, int k) {
        if (root == null) return;
        helper(root.left, k);
        if (stack.size() == k) return;
        stack.push(root);
        helper(root.right, k);
    }
}
