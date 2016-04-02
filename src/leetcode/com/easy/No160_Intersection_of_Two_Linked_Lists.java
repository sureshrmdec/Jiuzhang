package leetcode.com.easy;

import leetcode.com.util.ListNode;

/**
 * Created by jason on 2016/3/30.
 * Location:
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * ************************************************************************
 * Description:
 * ************************************************************************
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * A:          a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * ************************************************************************
 * Solution:
 * 1.曾经想过用交叉比较的方式，但是忽略了重复元素的出现位置，所以失败了
 * 2.看了网络答案才意识找到第一个链表的末尾，再和第二个链表链接，如果是有交叉元素的话，那么会形成环形链表
 * 用环形链表的快慢指针就可以实现了，当然这个fast和slow的联系还需要再自己推导
 * *************************************************************************
 * Hints:
 * 快慢指针的问题，要再消化消化
 * Reference：http://blog.sina.com.cn/s/blog_624ca80801011u6m.html
 */
public class No160_Intersection_of_Two_Linked_Lists {
    public static void main(String[] args) {
        No160_Intersection_of_Two_Linked_Lists obj = new No160_Intersection_of_Two_Linked_Lists();

        int i = 1;
        ListNode dummy = new ListNode(-1);
        ListNode head = new ListNode(i++);
        dummy.next = head;
        for (; i < 97; i++) {
            head.next = new ListNode(i);

            System.out.print("  " + head.val);
            head = head.next;
        }
        System.out.print("  " + head.val);
        System.out.println();
        ListNode slow = dummy.next;
        ListNode fast = dummy.next.next;
        while (fast != null && fast.next != null) {
            System.out.print(fast.val + " ");
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println();
        System.out.println("slow: " + slow == null ? "null" : slow.val);
        System.out.println("fast: " + fast == null ? "null" : fast.val);

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        //get the tail of listA
        ListNode node = headA;
        while (node.next != null) {
            node = node.next;
        }
        //connect A & B
        node.next = headB;
        ListNode rst = listCycleII(headA);
        node.next = null;
        return rst;
    }

    private ListNode listCycleII(ListNode head) {
        ListNode slow = head, fast = head.next;

        while (slow != fast) {
            //非环形链表
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        //make sure the head of the circle
        slow = head;
        //bug2:head.next -> fast.next
        fast = fast.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
