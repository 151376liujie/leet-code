package com.proj.jonny.leetcode.Interview.questions.link;

import com.proj.jonny.leetcode.link.ListNode;

/**
 * 返回倒数第 k 个节点
 * <p>
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例：
 * <p>
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 * <p>
 * 给定的 k 保证是有效的。
 * <p>
 * Author: jonny
 * Time: 2020-03-29 23:17.
 */
public class Solution_02_02 {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);


        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        System.out.println(kthToLast(head, 3));
    }

    public static int kthToLast(ListNode head, int k) {

        if (head == null) {
            return -1;
        }

        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.val;
    }

}
