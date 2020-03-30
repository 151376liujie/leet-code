package com.proj.jonny.leetcode.link;

/**
 * Author: jonny
 * Time: 2020-03-18 18:05.
 */
public class Solution_21 {


    public static void main(String[] args) {
        ListNode head = new ListNode(5);
//        ListNode second = new ListNode(2);
//        ListNode third = new ListNode(4);
//        head.next = second;
//        second.next = third;

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(4);
        one.next = two;
        two.next = three;

        System.out.println(mergeTwoLists(head, one));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode cur = l2;
        while (cur != null) {
            l1 = addNode(l1, cur.val);
            cur = cur.next;
        }
        return l1;
    }

    /**
     * 向以head为头的有序链表中插入元素data
     *
     * @param head
     * @param data
     * @return
     */
    private static ListNode addNode(ListNode head, int data) {

        ListNode cur = head;
        ListNode prev = null;
        while (cur != null && cur.val <= data) {
            prev = cur;
            cur = cur.next;
        }

        ListNode node = new ListNode(data);
        //要在链表头插入node
        if (prev == null) {
            node.next = head;
            return node;
        }
        node.next = cur;
        prev.next = node;
        return head;
    }
}
