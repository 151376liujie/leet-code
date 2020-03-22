package com.proj.jonny.leetcode.link;

/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 示例：
 * <p>
 *  输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * <p>示例：
 * <p>输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例：
 * <p>输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * <p>
 * Author: jonny
 * Time: 2020-03-22 21:53.
 */
public class Solution_141 {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(0);
        ListNode four = new ListNode(-4);

        head.next = two;
        two.next = three;
        three.next = four;
        four.next = two;

        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
