package leetcode.com.medium;

import leetcode.com.util.TreeNode;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by tclresearchamerica on 4/28/16.
 * ****************************************************
 * Location:
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * ****************************************************
 * Description:
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * <p>
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 * ****************************************************
 * Analysis:
 * 目标节点可能为左/右子树,所以想着一直向左找到最左侧的节点---即最小值,然后再往回倒腾k--,如果不满足要求就再将右节点入栈时间复杂度:O(n)
 * 是否可以用树本身的特性来完结这个问题呢?
 * 其实可以用一个今天上午用到的priorityQueue来完成,
 * ****************************************************
 */
public class No230_Kth_Smallest_Element_in_a_BST {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);

        kthHelper(queue, root, k);
        Iterator<Integer> it = queue.iterator();
        int result = 0;
        while (it.hasNext()) {
            result = it.next();
        }
        return result;
    }

    private void kthHelper(PriorityQueue<Integer> queue, TreeNode root, int k) {
        if (root == null) return;
        boolean minFlg = false;
        if (root.left == null && root.right == null && queue.size() == 0) {
            //只有最小节点满足这个要求
            queue.add(root.val);

            minFlg = true;
        }
        if (k == queue.size()) return;
        if (root.left != null) kthHelper(queue, root.left, k);
        if (minFlg == false) {

            queue.add(root.val);
            if (k == queue.size()) {
                return;
            }
        }

        if (root.right != null) kthHelper(queue, root.right, k);
    }

}
