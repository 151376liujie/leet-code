package com.proj.jonny.leetcode.link.interview;

import com.proj.jonny.leetcode.link.LinkUtils;
import com.proj.jonny.leetcode.link.ListNode;

/**
 * 面试题22. 链表中倒数第k个节点
 * <p>
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 */
public class Solution_22 {

    public static void main(String[] args) {
        ListNode head = LinkUtils.of(1, 2, 3, 4, 5, 6);
        System.out.println(getKthFromEnd(head, 3));
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
