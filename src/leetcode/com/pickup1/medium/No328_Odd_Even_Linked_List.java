package leetcode.com.pickup1.medium;

import leetcode.com.util.ListNode;

import java.util.List;

/**
 * Created by tclresearchamerica on 6/27/16.
 * ****************************************************
 * Location:
 * https://leetcode.com/problems/odd-even-linked-list/
 * ****************************************************
 * Descriptioin:
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are
 * talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * <p>
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 * ****************************************************
 */
public class No328_Odd_Even_Linked_List {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode evenHead = new ListNode(-1);
        ListNode evenPrev = evenHead;
        while (head != null) {
            if (head.val % 2 == 0) {
                evenPrev.next = head;
                prev.next = head.next;
                head = head.next;
                evenPrev.next = null;
            } else {
                prev = head;
                head = head.next;
            }
        }
        prev.next = evenHead.next;
        return dummy.next;

    }
}
