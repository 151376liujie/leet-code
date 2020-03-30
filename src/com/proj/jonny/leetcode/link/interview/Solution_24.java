package com.proj.jonny.leetcode.link.interview;

import com.proj.jonny.leetcode.link.ListNode;

/**
 * 反转链表
 * <p>
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 */

public class Solution_24 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        head.next = two;
        two.next = three;
        three.next = four;
//        System.out.println(reverseList(head));
        System.out.println(reverseListByRecursive(head));

    }

    /**
     * 递归方法实现链表反转
     *
     * @param head
     * @return
     */
    private static ListNode reverseListByRecursive(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseListByRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private static ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
